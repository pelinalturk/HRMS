package kodlamaio.Hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.UserService;
import kodlamaio.Hrms.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	private UserDao userDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public UserManager(UserDao userDao, CloudinaryService cloudinaryService) {
		super();
		this.userDao = userDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result saveImage(MultipartFile multipartFile, int userId) {
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(multipartFile).getData(); 
		String image= uploader.get("url");
		User user = userDao.getOne(userId);
		user.setPhoto(image);
		userDao.save(user);
		return new SuccessResult("Kayıt Başarılı");
	}

}
