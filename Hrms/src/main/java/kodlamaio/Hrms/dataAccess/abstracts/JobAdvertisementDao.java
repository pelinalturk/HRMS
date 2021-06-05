package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement>findByIsActiveTrue();

	List<JobAdvertisement> findByIsActiveTrueOrderByCreatedDateAsc();
	
	List<JobAdvertisement> getByEmployer_CompanyName(String companyName);
	
	
}
