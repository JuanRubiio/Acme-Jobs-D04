
package acme.entities.duty;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.entities.job.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Duty extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 5135976617756222620L;

	@NotBlank
	private String				title;

	@NotBlank
	private String				description;

	@NotNull
	@Range(min = 0, max = 100)
	private Double				percentage;

	//Relationships----------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Job					job;

}
