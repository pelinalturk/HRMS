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
	//private ModelMapper modelMapper;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,CloudinaryService cloudinaryService,DtoConverterService dtoConverterService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cloudinaryService=cloudinaryService;
		this.dtoConverterService = dtoConverterService;
		//this.modelMapper = modelMapper;
	}
	
//	private CurriculumVitae dtoConverter(CandidateWithCvDto candidateWithCvDto) {
//		return modelMapper.map(candidateWithCvDto, CurriculumVitae.class);
//	}

	@Override
	public DataResult<List<CandidateWithCvDto>> getAll() {
		return new SuccessDataResult<List<CandidateWithCvDto>> 
		(dtoConverterService.dtoConverter(curriculumVitaeDao.findAll(), CandidateWithCvDto.class),"CV getirildi");
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		if (curriculumVitae.getForeignLanguage() != null) {
			curriculumVitae.getForeignLanguage().forEach(lang -> lang.setCurriculumVitae(curriculumVitae));
		}
		if (curriculumVitae.getSchool() != null) {
			curriculumVitae.getSchool().forEach(lang -> lang.setCurriculumVitae(curriculumVitae));
		}
		if (curriculumVitae.getTechnology() != null) {
			curriculumVitae.getTechnology().forEach(lang -> lang.setCurriculumVitae(curriculumVitae));
		}
		if (curriculumVitae.getJobExperience() != null) {
			curriculumVitae.getJobExperience().forEach(lang -> lang.setCurriculumVitae(curriculumVitae));
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

	@Override
	public DataResult<List<CurriculumVitaeDto>> getCv() {
		return new SuccessDataResult<List<CurriculumVitaeDto>>
		(this.dtoConverterService.dtoConverter(this.curriculumVitaeDao.findAll(), CurriculumVitaeDto.class),"Data getirildi");
	}
}
