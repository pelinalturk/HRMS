package kodlamaio.Hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementsFilterDto;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement>findByIsActive(boolean active);
	List<JobAdvertisement> findByIsActiveTrueOrderByCreatedDateAsc();
	List<JobAdvertisement> getByEmployer_CompanyName(String companyName);
	JobAdvertisement getById(int id);
	List<JobAdvertisement>findByIsConfirm(boolean confirm);
	List<JobAdvertisement> getByEmployer_Id(int id);
	List<JobAdvertisement> findByIsActiveTrueAndIsConfirmTrue();
	List<JobAdvertisement> getByPositionLevelId(int id);
	List<JobAdvertisement> getByJobPositionId(int id);
	 @Query("Select j from kodlamaio.Hrms.entities.concretes.JobAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
		        +" and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
		        +" and ((:#{#filter.mannerOfWorkId}) IS NULL OR j.mannerOfWork.id IN (:#{#filter.mannerOfWorkId}))"
		        +" and ((:#{#filter.workingHourId}) IS NULL OR j.workingHour.id IN (:#{#filter.workingHourId}))"
		        + "and ((:#{#filter.positionLevelId}) IS NULL OR j.positionLevel.id IN (:#{#filter.positionLevelId}))"
		        +" and j.isActive=true")
	 public Page<JobAdvertisement> getByFilter(@Param("filter") JobAdvertisementsFilterDto jobAdvertisementFilter, Pageable pageable);
}
