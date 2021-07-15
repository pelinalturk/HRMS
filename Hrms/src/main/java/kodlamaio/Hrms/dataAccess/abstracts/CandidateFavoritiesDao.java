package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateFavorities;

public interface CandidateFavoritiesDao extends JpaRepository<CandidateFavorities, Integer>{
	List<CandidateFavorities> getByCandidateId(int candidateId);
	boolean existsByJobAdvertisement_Id(int id);
}
