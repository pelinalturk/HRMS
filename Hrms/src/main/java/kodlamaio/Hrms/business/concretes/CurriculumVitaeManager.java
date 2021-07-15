package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.Hrms.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;
import kodlamaio.Hrms.entities.dtos.CandidateWithCvDto;
import kodlamaio.Hrms.entities.dtos.CurriculumVitaeDto;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{
	private CurriculumVitaeDao curriculumVitaeDao;
	private CloudinaryService cloudinaryService;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,CloudinaryService cloudinaryService,DtoConverterService dtoConverterService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cloudinaryService=cloudinaryService;
		this.dtoConverterService = dtoConverterService;
	}
	

	@Override
	public DataResult<List<CandidateWithCvDto>> getAll() {
		return new SuccessDataResult<List<CandidateWithCvDto>> 
		(dtoConverterService.dtoConverter(curriculumVitaeDao.findAll(), CandidateWithCvDto.class),"CV getirildi");
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
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

	@Override
	public DataResult<List<CurriculumVitaeDto>> getCv() {
		return new SuccessDataResult<List<CurriculumVitaeDto>>
		(this.dtoConverterService.dtoConverter(this.curriculumVitaeDao.findAll(), CurriculumVitaeDto.class),"Data getirildi");
	}


	@Override
	public CurriculumVitae getByCandidateId(int id) {
		return this.curriculumVitaeDao.getByCandidateId(id);
	}


//	@Override
//	public List<CurriculumVitae> getByCandidateId(int id) {
//		return this.curriculumVitaeDao.getByCandidateId(id);
//		//return new SuccessResult<List<CurriculumVitae>>(this.curriculumVitaeDao.getByCandidateId(id), "CV bilgisi getirildi");
//	}
}
