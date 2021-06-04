package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.Hrms.entities.concretes.JobPosition;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	JobPosition findByTitle(String title);
}
