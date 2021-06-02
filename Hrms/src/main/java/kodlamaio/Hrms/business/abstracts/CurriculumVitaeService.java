package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	DataResult<List<CurriculumVitae>> getAll();
	Result add(CurriculumVitae curriculumVitae);
	List<CurriculumVitae> findAllByendingDateDesc();
	List<CurriculumVitae> findAllByJobExperience_StartingDateDesc();
	
}
