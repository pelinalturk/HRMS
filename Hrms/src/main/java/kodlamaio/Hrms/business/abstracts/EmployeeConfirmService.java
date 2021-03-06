package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.EmployeeConfirm;
import kodlamaio.Hrms.entities.dtos.EmployeeConfirmDto;

public interface EmployeeConfirmService {
	Result add(EmployeeConfirm employeeConfirm);
	DataResult<List<EmployeeConfirmDto>> findByIsActive(boolean isActive);

}
