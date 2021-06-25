package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_favorities")
public class CandidateFavorities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity = JobAdvertisement.class)
	private JobAdvertisement jobAdvertisement;
	
//	@ManyToMany
//	@JoinColumn(name = "candidate_id")
//	private Candidate candidate;
	
//	@ManyToMany(mappedBy = "candidatefavorities")
//	List<Candidate> candidates;
	
	@ManyToOne(targetEntity = Candidate.class)
	private Candidate candidate;
}
