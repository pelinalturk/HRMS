package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.entities.concretes.Candidate;

public interface RegisterCandidateService {
	Candidate registerCandidate(Candidate candidate) throws Exception;
}
