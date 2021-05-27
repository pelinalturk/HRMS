package kodlamaio.Hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.VerificationCodeService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.Hrms.entities.concretes.User;
import kodlamaio.Hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(User user) {
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.set_verified(false);
		verificationCode.setCode("deneme kodu");
		verificationCode.setUser_id(user);
		this.verificationCodeDao.save(verificationCode);
		return new SuccessResult("kod kaydedildi");
	}
}
