package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.dtos.CandidateWithCvDto;

public interface CandidateService {
	List<Candidate> getall();
	Result add(Candidate candidate);
	Result update(Candidate candidate);
	Candidate getById(int id);
	Result login(String email, String password);
	DataResult<List<CandidateWithCvDto>> getByCandidateId(int id);
}
