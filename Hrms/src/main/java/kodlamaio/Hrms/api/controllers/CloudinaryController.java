package kodlamaio.Hrms.api.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


//@RestController
//@RequestMapping("/cloudinary")
//@CrossOrigin
//public class CloudinaryController {
//	
//	@Autowired
//	CloudinaryService cloudinaryService;
//	
//	@PostMapping("/upload")
//	public ResponseEntity<Map> upload(@RequestParam MultipartFile multipartFile) throws IOException{
//		BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
//		if (bufferedImage == null) {
//			
//		}
//		Map result = cloudinaryService.upload(multipartFile);
//		return new ResponseEntity(result, HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Map> delete(@PathVariable("id") String id) throws IOException{
//		Map result = cloudinaryService.delete(id);
//		return new ResponseEntity(result, HttpStatus.OK);
//	}

