package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Employee;
import kodlamaio.Hrms.entities.concretes.EmployeeConfirm;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.dtos.EmployeeConfirmDto;

public interface EmployeeConfirmService {
	Result add(Employer employer);
	DataResult<List<EmployeeConfirmDto>> findByIsActive(boolean isActive);
}
