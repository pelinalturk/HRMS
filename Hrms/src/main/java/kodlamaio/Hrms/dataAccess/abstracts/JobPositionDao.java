package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.Hrms.entities.concretes.JobPositions;

@Repository
public interface JobPositionDao extends JpaRepository<JobPositions, Integer>{
	JobPositions findByTitle(String title);
}
