package kodlamaio.Hrms.Adapters.abstracts;

import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	boolean checkCandidate(Candidate candidate);
}
