
package acme.entities.job;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.roles.Employer;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "deadline"), @Index(columnList = "status")
})
public class Job extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 3116209731057966366L;

	@Column(unique = true)
	@NotBlank
	@Length(min = 5, max = 10)
	private String				reference;

	@NotBlank
	private String				status;

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotNull
	@Valid
	private Money				salary;

	@URL
	private String				link;

	private Boolean				active;

	@NotBlank
	private String				description;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Employer			employer;


	//Relationships----------------------------

	@Transient
	public Boolean getActive() {
		Boolean result = false;
		Date d = new Date();
		if (this.deadline.after(d) && "Published".equals(this.status)) {
			result = true;
		}
		return result;
	}

}
