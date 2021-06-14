package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementDto;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement>findByIsActive(boolean active);

	List<JobAdvertisement> findByIsActiveTrueOrderByCreatedDateAsc();
	
	List<JobAdvertisement> getByEmployer_CompanyName(String companyName);
	
	JobAdvertisement getById(int id);
	
	List<JobAdvertisement>findByIsConfirm(boolean confirm);
}
