package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.entities.concretes.WorkingHour;

public interface WorkingHourService {
	DataResult<List<WorkingHour>> getAll();
}
