package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {
	Result add (EmployerUpdate employerUpdate);
	Result confirm (int employeeId, boolean confirm, Employer employer);
	EmployerUpdate findByEmployer_Id(int employerId);
}
