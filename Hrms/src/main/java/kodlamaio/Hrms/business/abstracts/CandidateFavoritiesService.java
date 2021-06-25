package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CandidateFavorities;

public interface CandidateFavoritiesService {
	Result add(CandidateFavorities candidateFavorities);
	DataResult<List<CandidateFavorities>> getAll();
}
