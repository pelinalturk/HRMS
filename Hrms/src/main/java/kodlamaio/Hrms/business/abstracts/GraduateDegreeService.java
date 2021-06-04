package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.GraduateDegree;
import kodlamaio.Hrms.entities.concretes.JobPosition;

public interface GraduateDegreeService {
	DataResult<List<GraduateDegree>> getAll();
	Result add(GraduateDegree graduateDegree);
}
