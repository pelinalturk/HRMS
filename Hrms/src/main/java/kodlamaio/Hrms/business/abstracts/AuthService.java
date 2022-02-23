package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.entities.dtos.LoginDto;

public interface AuthService {
	String login(LoginDto loginDto) throws Exception;
}
