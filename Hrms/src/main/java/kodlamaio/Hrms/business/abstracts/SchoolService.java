package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.School;
import kodlamaio.Hrms.entities.dtos.SchoolAddDto;
import kodlamaio.Hrms.entities.dtos.SchoolGetDto;

public interface SchoolService {
	DataResult<List<SchoolGetDto>> getAll();
	Result add(SchoolAddDto schoolAddDto);
	DataResult<List<School>> getBySchoolNameOrderByEndingDateDesc(int id);
}
