package kodlamaio.Hrms.Adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.Adapters.abstracts.CandidateCheckService;
import kodlamaio.Hrms.entities.concretes.Candidate;

@Service("fakeMernis")
public class FakeCandidateCheckManager implements CandidateCheckService{

	@Override
	public boolean checkCandidate(Candidate candidate) {
		return true;
	}

}
