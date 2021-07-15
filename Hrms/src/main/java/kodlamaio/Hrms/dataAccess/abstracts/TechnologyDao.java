package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
	List<Technology>getByCandidateId(int id);
}
