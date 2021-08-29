package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateCVConfidentiality;

public interface CandidateCVConfidentialityDao extends JpaRepository<CandidateCVConfidentiality, Integer>{
	CandidateCVConfidentiality getByCandidateId(int id);
	List<CandidateCVConfidentiality> getByConfidentialityTrue();
	boolean existsByCandidateId(int id);
}
