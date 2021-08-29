package kodlamaio.Hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.Hrms.entities.concretes.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByNationalIdentity(String identity_number);
	@Query("From Candidate where email=:email and password=:password")
	Candidate login(String email, String password);
	
	List<Candidate>getById(int id);
}
