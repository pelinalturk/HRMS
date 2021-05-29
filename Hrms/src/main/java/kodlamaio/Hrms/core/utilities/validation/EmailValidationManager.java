package kodlamaio.Hrms.core.utilities.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmailValidationDao;
import kodlamaio.Hrms.entities.concretes.User;
import kodlamaio.Hrms.entities.concretes.VerificationCode;

@Service
public class EmailValidationManager {

//	//private  EmailValidationDao emailValidationDao;
//	private EmailValidationService service;
//	
//	@Autowired
//	public EmailValidationManager(EmailValidationService service) {
//		super();
//		this.service = service;
//	}
//
//	@Override
//	public Result add(User user) {
//		VerificationCode verificationCode = new VerificationCode();
//		verificationCode.set_verified(false);
//		verificationCode.setCode("deneme kodu gönder");
//		verificationCode.setUser_id(user);
//		this.service.add(user);
//		return new SuccessResult("kod kaydedildi");
//	}
}
