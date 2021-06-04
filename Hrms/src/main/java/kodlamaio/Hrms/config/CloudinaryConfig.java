package kodlamaio.Hrms.config;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.Hrms.core.utilities.cloudinary.CloudinaryManager;
import kodlamaio.Hrms.core.utilities.cloudinary.CloudinaryService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
	
	@Value("${pln.access-key}")
	String accessKey;
	@Value("${pln.secret-key}")
	String secretKey;
	
	@Bean
	public Cloudinary cloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "pelin",
                "api_key", accessKey,
                "api_secret", secretKey));
    }

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }
	
}
