package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobExperience;
import kodlamaio.Hrms.entities.dtos.JobExperienceAddDto;

public interface JobExperienceService {
	DataResult<List<JobExperience>> getAll();
	Result add(JobExperienceAddDto jobExperienceAddDto);
	DataResult<List<JobExperience>>findAllByCurriculumVitaeIdOrderByEndingDateDesc(int id);
	Result delete(int id);
	Result update (JobExperience jobExperience);
}
