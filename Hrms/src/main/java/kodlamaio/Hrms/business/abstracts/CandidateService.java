package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateService {
	List<Candidate> getall();
	Result add(Candidate candidate);
	Result update(Candidate candidate);
}
