package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;
import kodlamaio.Hrms.entities.dtos.EmployerUpdateDto;

public interface EmployerService {
	DataResult<List<Employer>> getall();
	Result add(Employer employer);
	DataResult<List<Employer>>findByIsConfirm(boolean confirm);
	Employer getById(int id);
	DataResult<EmployerUpdate> confirmUpdate(EmployerUpdateDto employerUpdateDto, int employerId);
	DataResult<Employer> updateEmployer(int employeeId, int employerId);
	DataResult<List<Employer>>IsActiveTrueIsConfirmFalse();
	Result login(String email, String password);
}
