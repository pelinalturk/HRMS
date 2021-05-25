package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{


	CandidateDao candidateDao;
	UserDao userDao;
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao=candidateDao;
	}
	@Override
	public List<Candidate> getall() {
		return this.candidateDao.findAll();
	}
	@Override
	public Result add(Candidate candidate) {
		
		if(this.userDao.findByEmail(candidate.getEmail()) != null) 
	    {
			return new ErrorResult("Bu mail adresi sistemde kayıtlıdır!");
		}
		else if(this.candidateDao.findByNationalIdentity(candidate.getNationalIdentity()) != null)
		{
			return new ErrorResult("Bu T.C. Kimlik numarası sistemde kayıtlıdır!");		
		}
		this.candidateDao.save(candidate);
		
		return new SuccessResult("Kayıt başarılıdır.");
	}
}
