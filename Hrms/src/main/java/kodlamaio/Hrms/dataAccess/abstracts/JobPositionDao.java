package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.JobPositions;

public interface JobPositionDao extends JpaRepository<JobPositions, Integer>{

}
