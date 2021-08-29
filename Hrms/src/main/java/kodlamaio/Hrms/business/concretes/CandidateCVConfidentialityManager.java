package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateCVConfidentialityService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateCVConfidentialityDao;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.concretes.CandidateCVConfidentiality;

@Service
public class CandidateCVConfidentialityManager implements CandidateCVConfidentialityService{

	private CandidateCVConfidentialityDao candidateCVConfidentialityDao;
	private CandidateCVConfidentiality candidateCVConfidentiality;
	
	@Autowired
	public CandidateCVConfidentialityManager(CandidateCVConfidentialityDao candidateCVConfidentialityDao) {
		super();
		this.candidateCVConfidentialityDao = candidateCVConfidentialityDao;
	}
	
	public void update(int id, boolean change, Candidate candidate){
		candidateCVConfidentiality=this.candidateCVConfidentialityDao.findById(id).get();
		candidateCVConfidentiality.setConfidentiality(change);
		candidateCVConfidentiality.setCandidate(candidate);
		this.candidateCVConfidentialityDao.save(candidateCVConfidentiality);
	}
	@Override
	public Result add(CandidateCVConfidentiality candidateCVConfidentiality) {
		if(this.candidateCVConfidentialityDao.existsByCandidateId(candidateCVConfidentiality.getCandidate().getId())) {
			update(candidateCVConfidentiality.getId(), candidateCVConfidentiality.isConfidentiality(), candidateCVConfidentiality.getCandidate());
			return new SuccessResult("Değişiklik güncellendi.");
		}
		this.candidateCVConfidentialityDao.save(candidateCVConfidentiality);
		return new SuccessResult("Değişiklik eklendi.");
	}
	@Override
	public DataResult<CandidateCVConfidentiality> getByCandidateId(int id) {
		return new SuccessDataResult<CandidateCVConfidentiality>(this.candidateCVConfidentialityDao.getByCandidateId(id), null);
	}
	@Override
	public List<CandidateCVConfidentiality> getByConfidentialityTrue() {
		return this.candidateCVConfidentialityDao.getByConfidentialityTrue();
	}

}
