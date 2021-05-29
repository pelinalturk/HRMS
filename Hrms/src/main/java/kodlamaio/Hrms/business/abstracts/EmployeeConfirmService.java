package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Employee;
import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployeeConfirmService {
	Result add(Employer employer);
}
