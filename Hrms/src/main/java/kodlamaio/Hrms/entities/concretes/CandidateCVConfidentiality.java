package kodlamaio.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_cv_confidentialities")
public class CandidateCVConfidentiality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id",referencedColumnName = "id",nullable = false)
	Candidate candidate;
	
	@Column(name = "cv_confidentiality")
	private boolean confidentiality;	
}
