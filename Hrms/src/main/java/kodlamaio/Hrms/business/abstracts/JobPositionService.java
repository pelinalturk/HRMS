package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobPositions;

public interface JobPositionService {
	DataResult<List<JobPositions>> getall();
	Result add(JobPositions jobPositions);
}
