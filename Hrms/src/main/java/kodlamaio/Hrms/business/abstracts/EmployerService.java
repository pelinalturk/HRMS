package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployerService {
	List<Employer> getall();
	Result add(Employer employer);
	
}
