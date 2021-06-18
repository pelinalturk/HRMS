package kodlamaio.Hrms.business.concretes;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.UserService;
import kodlamaio.Hrms.core.utilities.result.Result;

@Service
public class UserManager implements UserService{

	@Override
	public Result saveImage(MultipartFile multipartFile, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
