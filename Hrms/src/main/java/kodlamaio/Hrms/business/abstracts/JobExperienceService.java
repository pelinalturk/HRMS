package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	DataResult<List<JobExperience>> getAll();
	Result add(JobExperience jobExperience);
}
