package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	//DataResult<JobAdvertisement> getByJobAdvertisementName(String name);
	DataResult<List<JobAdvertisement>> getByIsActive();
	DataResult<List<JobAdvertisement>>getByIsActiveAndCreatedDate();
	DataResult<List<JobAdvertisement>>getByEmployer_CompanyName(String companyName);
}
