package kodlamaio.Hrms.core.utilities.validation;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.entities.concretes.User;

public interface EmailValidationService {
	public boolean emailValidation(User user);
}
