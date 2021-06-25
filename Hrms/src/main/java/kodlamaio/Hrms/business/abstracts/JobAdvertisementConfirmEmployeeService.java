package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import kodlamaio.Hrms.entities.concretes.JobAdvertisementConfirmEmployee;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementConfirmEmployeeDto;

public interface JobAdvertisementConfirmEmployeeService {
	Result add(JobAdvertisementConfirmEmployee jobAdvertisementConfirmEmployee);
	DataResult<List<JobAdvertisementConfirmEmployee>> findByIsActive(boolean isActive);
	//DataResult<List<JobAdvertisementConfirmEmployee>> getByIsConfirmed(boolean isActive);
}
