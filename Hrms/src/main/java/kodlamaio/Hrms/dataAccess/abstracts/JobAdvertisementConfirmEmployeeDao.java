package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.JobAdvertisementConfirmEmployee;

public interface JobAdvertisementConfirmEmployeeDao extends JpaRepository<JobAdvertisementConfirmEmployee, Integer>{
	List<JobAdvertisementConfirmEmployee> getByIsConfirmed(boolean isActive);
	JobAdvertisementConfirmEmployee getById(int jobAdvertisementIs);
	JobAdvertisementConfirmEmployee getByJobAdvertisement_Id(int id);
	boolean existsByJobAdvertisement_Id(int id);
}
