package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.ForeignLanguage;
import kodlamaio.Hrms.entities.dtos.ForeignLanguageDto;

public interface ForeignLanguageService {
	DataResult<List<ForeignLanguageDto>> getAll();
	Result add(ForeignLanguageDto foreignLanguageDto);
	Result update(int languageLevel, int id);
	Result delete(int id);
	DataResult<ForeignLanguage> getByLanguage(String language);
	List<ForeignLanguage> getByCandidateId(int id);
}
