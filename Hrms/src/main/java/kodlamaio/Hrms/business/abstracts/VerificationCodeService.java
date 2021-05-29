package kodlamaio.Hrms.business.abstracts;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.User;

public interface VerificationCodeService {
	Result add(User user);
}
