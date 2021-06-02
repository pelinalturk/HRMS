package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	DataResult<List<ForeignLanguage>> getAll();
	Result add(ForeignLanguage foreignLanguage);
}
