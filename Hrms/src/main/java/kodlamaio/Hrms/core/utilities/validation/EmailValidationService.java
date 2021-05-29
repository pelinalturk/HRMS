package kodlamaio.Hrms.core.utilities.validation;


import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.User;

public interface EmailValidationService {
	Result add(User user);
}
