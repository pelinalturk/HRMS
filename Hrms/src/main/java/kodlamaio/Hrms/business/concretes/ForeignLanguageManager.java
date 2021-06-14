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
	//private ModelMapper modelMapper;
	private DtoConverterService dtoConverterService;
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao, DtoConverterService dtoConverterService) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
		this.dtoConverterService=dtoConverterService;
		//this.modelMapper=modelMapper;
	}
	
//	private ForeignLanguage dtoConverter(ForeignLanguageDto foreignLanguageDto) {
//		return modelMapper.map(foreignLanguageDto, ForeignLanguage.class);
//	}
	
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

}
