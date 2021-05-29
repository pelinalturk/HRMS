package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	//DataResult<JobAdvertisement> getByJobAdvertisementName(String name);
	DataResult<List<JobAdvertisement>> findAllByIsActiveTrue();
	DataResult<List<JobAdvertisement>> findAllByIsActiveTrueOrderByCreatedDateAsc();
	DataResult<List<JobAdvertisement>>getByEmployer_CompanyName(String companyName);
	Result update(JobAdvertisement jobAdvertisement);
}
