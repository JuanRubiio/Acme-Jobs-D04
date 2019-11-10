
package acme.features.authenticated.companyrecord;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.companyrecord.CompanyRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

public class AuthenticatedCompanyRecordCreateService implements AbstractCreateService<Administrator, CompanyRecord> {

	@Autowired
	AuthenticatedCompanyRecordRepository repository;


	@Override
	public boolean authorise(final Request<CompanyRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<CompanyRecord> request, final CompanyRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<CompanyRecord> request, final CompanyRecord entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "ceoName", "description", "webSite", "phone", "email", "incorporated", "stars");
	}

	@Override
	public CompanyRecord instantiate(final Request<CompanyRecord> request) {
		CompanyRecord result;

		result = new CompanyRecord();
		return result;
	}

	@Override
	public void validate(final Request<CompanyRecord> request, final CompanyRecord entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<CompanyRecord> request, final CompanyRecord entity) {
		this.repository.save(entity);
	}

}
