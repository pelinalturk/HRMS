package kodlamaio.Hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.core.utilities.result.Result;

public interface UserService {
	Result saveImage(MultipartFile multipartFile, int userId);
}
