package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CandidateJobApplication;

public interface CandidateJobApplicationService {
	Result add(CandidateJobApplication candidateJobApplication);
	DataResult<List<CandidateJobApplication>> getByCandidateId(int id);
	DataResult<List<CandidateJobApplication>> getByJobAdvertisementEmployerId(int id);
	DataResult<List<CandidateJobApplication>> getByJobAdvertisementId(int id);
}
