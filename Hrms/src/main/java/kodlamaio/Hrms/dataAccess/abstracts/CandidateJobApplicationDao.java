package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateJobApplication;

public interface CandidateJobApplicationDao extends JpaRepository<CandidateJobApplication, Integer>{
	List<CandidateJobApplication> getByCandidateId(int id);
	List<CandidateJobApplication> getByJobAdvertisementEmployerId(int id);
	List<CandidateJobApplication> getByJobAdvertisementId(int id);
}
