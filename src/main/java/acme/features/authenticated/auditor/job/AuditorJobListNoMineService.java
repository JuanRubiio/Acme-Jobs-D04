
package acme.features.authenticated.auditor.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.job.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuditorJobListNoMineService implements AbstractListService<Auditor, Job> {

	@Autowired
	AuditorJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "reference", "description");
	}

	@Override
	public Collection<Job> findMany(final Request<Job> request) {

		assert request != null;
		Collection<Job> result;
		Principal principal;
		principal = request.getPrincipal();
		Collection<Job> jobsAuditor = this.repository.findManyByAuditorId(principal.getActiveRoleId());
		result = this.repository.findAllJobs();
		result.removeAll(jobsAuditor);

		return result;
	}

}
