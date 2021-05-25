package kodlamaio.Hrms.dataAccess.abstracts;

import kodlamaio.Hrms.entities.concretes.User;

public interface UserDao {
	User findByEmail(String email);
}
