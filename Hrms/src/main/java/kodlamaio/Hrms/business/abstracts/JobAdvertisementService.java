package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementsFilterDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisementDto>> getAll();
	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	DataResult<List<JobAdvertisementDto>> findAllByIsActive(boolean active);
	DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrueOrderByCreatedDateAsc();
	DataResult<List<JobAdvertisementDto>>getByEmployer_CompanyName(String companyName);
	Result update(JobAdvertisement jobAdvertisement);
	JobAdvertisement getById(int id);
	DataResult<List<JobAdvertisementDto>>findByIsConfirm(boolean confirm);
	List<JobAdvertisement> getByEmployerId(int id);
	DataResult<List<JobAdvertisement>> findByIsActiveTrueAndIsConfirmTrue();
	DataResult<List<JobAdvertisement>> findByIsActiveTrueAndIsConfirmTrue(int pageNo, int pageSize);
	DataResult<List<JobAdvertisement>> getByPositionLevelId(int id);
	DataResult<List<JobAdvertisement>> getByJobPositionId(int id);
	DataResult<List<JobAdvertisement>> getByFilterJob(int pageNo, int pageSize, JobAdvertisementsFilterDto jobAdvertisementFilter);

}
