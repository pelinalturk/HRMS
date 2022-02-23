package kodlamaio.Hrms.business.abstracts;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.core.utilities.result.Result;

public interface UserService extends UserDetailsService{
	Result saveImage(MultipartFile multipartFile, int userId);
}
