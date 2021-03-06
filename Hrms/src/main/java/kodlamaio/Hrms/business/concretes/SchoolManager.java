package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.SchoolService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.Hrms.entities.concretes.School;
import kodlamaio.Hrms.entities.dtos.SchoolAddDto;
import kodlamaio.Hrms.entities.dtos.SchoolGetDto;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao, DtoConverterService dtoConverterService) {
		super();
		this.schoolDao = schoolDao;
		this.dtoConverterService=dtoConverterService;
	}
	

	@Override
	public DataResult<List<SchoolGetDto>> getAll() {
		return new SuccessDataResult<List<SchoolGetDto>> 
		(this.dtoConverterService.dtoConverter(this.schoolDao.findAll(), SchoolGetDto.class),"Data Listelendi");
	}

	@Override
	public Result add(SchoolAddDto schoolAddDto) {
		this.schoolDao.save((School) dtoConverterService.dtoClassConverter(schoolAddDto, School.class));
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public DataResult<List<School>> getBySchoolNameOrderByEndingDateDesc(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByCandidateIdOrderByEndingDateDesc(id), "Mezuniyet yıllarına göre listelendi");
	}


	@Override
	public Result delete(int id) {
		this.schoolDao.deleteById(id);
		return new SuccessResult("Data Silindi ");
	}


	@Override
	public Result update(SchoolAddDto schoolAddDto) {
		this.schoolDao.save((School) dtoConverterService.dtoClassConverter(schoolAddDto, School.class));
		return new SuccessResult("Güncellendi.");
	}

}
