package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;
import kodlamaio.Hrms.entities.dtos.CandidateWithCvDto;

public interface CurriculumVitaeService {
	DataResult<List<CurriculumVitae>> getAll();
	Result add(CurriculumVitae curriculumVitae);
	Result saveImage(MultipartFile multipartFile, int curriculumVitaeId);
	DataResult<List<CandidateWithCvDto>> findByCandidateId(int id);
	//List<CurriculumVitae> findAllByendingDateDesc();
	//List<CurriculumVitae> findAllByJobExperience_StartingDateDesc();
	
}