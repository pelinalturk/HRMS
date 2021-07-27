package kodlamaio.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_job_applications")
public class CandidateJobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = Candidate.class)
	private Candidate candidate;
	
	@ManyToOne(targetEntity = JobAdvertisement.class)
	private JobAdvertisement jobAdvertisement;
	
	@Column(name = "is_active")
	private boolean isActive = true;
	
	@Column(name = "application_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date applicationDate;
}
