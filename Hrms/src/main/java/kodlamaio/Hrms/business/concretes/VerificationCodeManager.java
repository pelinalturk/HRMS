package kodlamaio.Hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import kodlamaio.Hrms.business.abstracts.VerificationCodeService;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.Hrms.entities.concretes.User;
import kodlamaio.Hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	private VerificationCodeDao verificationCodeDao;
	private UserDao userDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao, UserDao userDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
		this.userDao=userDao;
	}
	
	public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
	
	public void verifiedControl(boolean verified, User user, String code) {
		VerificationCode getVerificationCode = new VerificationCode();
		getVerificationCode.set_verified(verified);
		getVerificationCode.setUser(user);
		getVerificationCode.setCode(generateString());
		this.verificationCodeDao.save(getVerificationCode);
	}
	
	@Override
	public Result add(User user) {
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.set_verified(false);
		verificationCode.setCode(generateString());
		verificationCode.setUser(user);
		this.verificationCodeDao.save(verificationCode);
		//verifiedControl(false, user);
		return new SuccessResult("kod kaydedildi");//metoda çevir parametrelere parantez içlerini ver	
	}

	@Override
	public Result control(int id, String code) {
		VerificationCode verificationCode = this.verificationCodeDao.getByUserId(id);
		User user=this.userDao.findById(id).get();
		if(this.verificationCodeDao.existsByUserIdAndCode(id, code)) {
			//verifiedControl(true, user);
			verificationCode.set_verified(true);
			verificationCode.setCode(code);
			verificationCode.setUser(user);
			this.verificationCodeDao.save(verificationCode);
			return new SuccessResult("Kod doğrulaması başarılı.");
		}
		return new ErrorResult("Kod doğrulanamadı.");
	}

}
