package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.Hrms.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{
	private CurriculumVitaeDao curriculumVitaeDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,CloudinaryService cloudinaryService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cloudinaryService=cloudinaryService;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		if (curriculumVitae.getForeignLanguages() != null) {
			curriculumVitae.getForeignLanguages().forEach(lang -> lang.setCvId(curriculumVitae));
		}
		if (curriculumVitae.getSchool() != null) {
			curriculumVitae.getSchool().forEach(lang -> lang.setCvId(curriculumVitae));
		}
		if (curriculumVitae.getTechs() != null) {
			curriculumVitae.getTechs().forEach(lang -> lang.setCvId(curriculumVitae));
		}
		if (curriculumVitae.getJobExperience() != null) {
			curriculumVitae.getJobExperience().forEach(lang -> lang.setCvId(curriculumVitae));
		}
				
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result saveImage(MultipartFile multipartFile, int curriculumVitaeId) {
		
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(multipartFile).getData(); 
		String image= uploader.get("url");
		CurriculumVitae curriculumVitae = curriculumVitaeDao.getOne(curriculumVitaeId);
		curriculumVitae.setPhoto(image);
		curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Kayıt Başarılı");
	}
	
	

//	@Override
//	public List<CurriculumVitae> findAllByJobExperience_StartingDateDesc() {
//		return this.curriculumVitaeDao.findAllByJobExperience_StartingDateDesc();
//	}
//
//	@Override
//	public List<CurriculumVitae> findAllByendingDateDesc() {
//		return this.curriculumVitaeDao.findAllBySchool_EndingDateDesc();
//	}

}
