package kodlamaio.Hrms.business.abstracts;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.User;
import kodlamaio.Hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result add(User user);
	//user id sine göre code aramasıyap sonra girilenle o aynı mı bak
	Result control(int id, String code);
}
