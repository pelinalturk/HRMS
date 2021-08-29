package kodlamaio.Hrms.business.abstracts;


import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCVConfidentiality;

public interface CandidateCVConfidentialityService {
	Result add(CandidateCVConfidentiality candidateCVConfidentiality);
	DataResult<CandidateCVConfidentiality> getByCandidateId(int id);
	List<CandidateCVConfidentiality> getByConfidentialityTrue();
}
