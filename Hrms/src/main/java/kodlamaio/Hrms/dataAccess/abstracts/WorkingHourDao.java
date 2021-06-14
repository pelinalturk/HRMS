package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.WorkingHour;

public interface WorkingHourDao extends JpaRepository<WorkingHour, Integer>{

}
