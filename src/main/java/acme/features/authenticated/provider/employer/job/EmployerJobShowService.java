
package acme.features.authenticated.provider.employer.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerJobShowService implements AbstractShowService<Employer, Job> {

	@Autowired
	private EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findJobById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = job.getActive() || !job.getActive() && employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "reference", "status", "salary", "link", "descriptor.description", "active", "descriptor.duties");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		int jobId;
		Job job;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findJobById(jobId);
		job.getDescriptor().getDuties().size();
		return job;
	}

}
