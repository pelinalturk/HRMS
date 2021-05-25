package kodlamaio.Hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByNationalIdentity(String identity_number);
}
