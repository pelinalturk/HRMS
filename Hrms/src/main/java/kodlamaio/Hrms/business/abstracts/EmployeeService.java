package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	Result add(Employee employee);
	Result update(Employee employee);
	Employee findById(int id);
}
