
package acme.features.authenticated.investorRecord;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.investorRecord.InvestorRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

public class AuthenticatedInvestorRecordDeleteService implements AbstractDeleteService<Administrator, InvestorRecord> {

	@Autowired
	AuthenticatedInvestorRecordRepository repository;


	@Override
	public boolean authorise(final Request<InvestorRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<InvestorRecord> request, final InvestorRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<InvestorRecord> request, final InvestorRecord entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "nameInvestor", "sector", "investingStatement", "stars");
	}

	@Override
	public InvestorRecord findOne(final Request<InvestorRecord> request) {
		assert request != null;

		InvestorRecord result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<InvestorRecord> request, final InvestorRecord entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<InvestorRecord> request, final InvestorRecord entity) {

		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

}
