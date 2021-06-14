package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisementDto>> getAll();
	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	//DataResult<JobAdvertisement> getByJobAdvertisementName(String name);
	DataResult<List<JobAdvertisementDto>> findAllByIsActive(boolean active);
	DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrueOrderByCreatedDateAsc();
	DataResult<List<JobAdvertisementDto>>getByEmployer_CompanyName(String companyName);
	Result update(JobAdvertisement jobAdvertisement);
	//Result updateConfirm(boolean confirm, int id);
	 JobAdvertisement getById(int id);
	 DataResult<List<JobAdvertisementDto>>findByIsConfirm(boolean confirm);
}
