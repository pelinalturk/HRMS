package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CoverLetter;
import kodlamaio.Hrms.entities.dtos.CoverLetterAddDto;

public interface CoverLetterService {
	Result add(CoverLetterAddDto coverLetter);
	Result delete(int id);
	List<CoverLetter> getByCandidateId(int id);
}
