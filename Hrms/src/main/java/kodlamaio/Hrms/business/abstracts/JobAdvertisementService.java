package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	//DataResult<List<JobAdvertisementDto>> getAll();
	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	//DataResult<JobAdvertisement> getByJobAdvertisementName(String name);
	DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrue();
	DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrueOrderByCreatedDateAsc();
	DataResult<List<JobAdvertisementDto>>getByEmployer_CompanyName(String companyName);
	Result update(JobAdvertisement jobAdvertisement);
}
