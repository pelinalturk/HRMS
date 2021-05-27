package kodlamaio.Hrms.core.utilities.validation;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.entities.concretes.User;

@Service
public class EmailValidationManager implements EmailValidationService{

	@Override
	public boolean emailValidation(User user) {
		
		return true;
	}

	

}
