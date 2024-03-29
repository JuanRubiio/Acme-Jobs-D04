
package acme.features.authenticated.thread;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.Thread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedThreadListService implements AbstractListService<Authenticated, Thread> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedThreadRepository repository;


	@Override
	public boolean authorise(final Request<Thread> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Thread> findMany(final Request<Thread> request) {
		assert request != null;

		Collection<Thread> result;
		Principal principal;
		principal = request.getPrincipal();
		result = this.repository.findManyByAuthenticatedId(principal.getAccountId());
		return result;
	}

	@Override
	public void unbind(final Request<Thread> request, final Thread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		UserAccount sender = entity.getSender();
		UserAccount recipient = entity.getRecipient();

		request.unbind(entity, model, "title", "moment");
		model.setAttribute("recipient", recipient.getUsername());
		model.setAttribute("sender", sender.getUsername());

	}

}
