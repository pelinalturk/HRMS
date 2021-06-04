package kodlamaio.Hrms.core.utilities.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.core.utilities.result.DataResult;

public interface CloudinaryService {
	DataResult<?> save(MultipartFile multipartFile);
}
