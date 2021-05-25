package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateService {
	List<Candidate> getall();
	Result add(Candidate candidate);
	//DataResult<Candidate> getMail(String mail);
}
