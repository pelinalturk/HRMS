package kodlamaio.Hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.Hrms.entities.concretes.ForeignLanguage;
import kodlamaio.Hrms.entities.dtos.ForeignLanguageDto;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{

	private ForeignLanguageDao foreignLanguageDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao, DtoConverterService dtoConverterService) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
		this.dtoConverterService=dtoConverterService;
	}
	
	@Override
	public DataResult<List<ForeignLanguageDto>> getAll() {
		return new SuccessDataResult<List<ForeignLanguageDto>>
		(this.dtoConverterService.dtoConverter(this.foreignLanguageDao.findAll(), ForeignLanguageDto.class),"Data Listelendi.");
	}

	@Override
	public Result add(ForeignLanguageDto foreignLanguageDto) {
		if(this.foreignLanguageDao.existsByLanguage(foreignLanguageDto.getLanguage())) {
			return new ErrorResult("Daha önce eklendi");
		}
		this.foreignLanguageDao.save((ForeignLanguage) dtoConverterService.dtoClassConverter(foreignLanguageDto, ForeignLanguage.class));
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result update(String languageLevel, int id) {
		ForeignLanguage foreignLanguage = new ForeignLanguage();
		foreignLanguage= this.foreignLanguageDao.findById(id).get();
		foreignLanguage.setLanguage(foreignLanguage.getLanguage());
		foreignLanguage.setCurriculumVitae(foreignLanguage.getCurriculumVitae());
		foreignLanguage.setLanguageLevel(languageLevel);
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Data Güncellendi.");
	}

	@Override
	public Result delete(int id) {
		this.foreignLanguageDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

}
