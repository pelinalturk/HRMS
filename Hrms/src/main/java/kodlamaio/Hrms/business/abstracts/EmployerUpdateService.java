package kodlamaio.Hrms.business.abstracts;
import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {
	EmployerUpdate findByEmployer_Id(int employerId);
	DataResult<List<EmployerUpdate>> findByIsConfirmFalse();
}
