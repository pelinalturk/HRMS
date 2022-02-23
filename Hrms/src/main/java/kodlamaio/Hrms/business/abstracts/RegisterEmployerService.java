package kodlamaio.Hrms.business.abstracts;


import javassist.NotFoundException;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Employer;

public interface RegisterEmployerService {
	Result registerEmployer(Employer employer) throws Exception;
	String employerConfirmation(int employerId, int systemUserId) throws NotFoundException, Exception;
}
