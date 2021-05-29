package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	//Aktif iş ilanları için Query
	//@Query("From JobAdvertisement where jobAdvertisement.isActive=:true")
	List<JobAdvertisement>findAllByIsActiveTrue();

	List<JobAdvertisement> findAllByIsActiveTrueOrderByCreatedDateAsc();
	
	//bir firmaya ait tüm aktif iş ilanları
	List<JobAdvertisement> getByEmployer_CompanyName(String companyName);
}
