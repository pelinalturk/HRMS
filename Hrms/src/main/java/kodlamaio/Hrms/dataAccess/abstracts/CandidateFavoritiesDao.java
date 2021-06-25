package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateFavorities;

public interface CandidateFavoritiesDao extends JpaRepository<CandidateFavorities, Integer>{
}
