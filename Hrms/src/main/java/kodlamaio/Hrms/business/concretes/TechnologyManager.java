package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.TechnologyService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.Hrms.entities.concretes.Technology;
import kodlamaio.Hrms.entities.dtos.TechnologyDto;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyDao technologyDao;
	//private ModelMapper modelMapper;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
		super();
		this.technologyDao = technologyDao;
		this.dtoConverterService=dtoConverterService;
		//this.modelMapper=modelMapper;
	}
	
//	private Technology dtoConverter(TechnologyDto technologyDto) {
//		return modelMapper.map(technologyDto,Technology.class);
//	}
	@Override
	public DataResult<List<TechnologyDto>> getAll() {
		return  new SuccessDataResult<List<TechnologyDto>>
		(this.dtoConverterService.dtoConverter(this.technologyDao.findAll(), TechnologyDto.class),"Data Listelendi");
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
		this.technologyDao.save((Technology) dtoConverterService.dtoClassConverter(technologyDto, Technology.class));
		return new SuccessResult("Data Eklendi");
	}

}
