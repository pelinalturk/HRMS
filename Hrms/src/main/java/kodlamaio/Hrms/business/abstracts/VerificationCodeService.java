package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.User;
import kodlamaio.Hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result add(User user);
}
