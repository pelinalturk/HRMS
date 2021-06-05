package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobExperience;
import kodlamaio.Hrms.entities.dtos.JobExperienceAddDto;
import kodlamaio.Hrms.entities.dtos.JobExperienceGetDto;

public interface JobExperienceService {
	DataResult<List<JobExperienceGetDto>> getAll();
	Result add(JobExperienceAddDto jobExperienceAddDto);
	DataResult<List<JobExperience>>findAllByCurriculumVitaeIdOrderByEndingDateDesc(int id);
}
