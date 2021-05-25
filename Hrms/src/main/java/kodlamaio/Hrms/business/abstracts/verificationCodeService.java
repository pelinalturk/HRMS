package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.User;

public interface verificationCodeService {
	List<User> getAll();
	Result add(User user);
}
