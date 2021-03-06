package kodlamaio.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements_confirm_employee")
public class JobAdvertisementConfirmEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private int id;
	
	@Column(name = "employee_id")
	private int employee;
	@ManyToOne(targetEntity = JobAdvertisement.class, fetch = FetchType.LAZY, optional = false )
	@JoinColumn(name ="job_advertisement_id", referencedColumnName = "id", nullable = false)
	private JobAdvertisement jobAdvertisement;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@JsonIgnore
	@Column(name = "confirm_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date confirmDate;
}
