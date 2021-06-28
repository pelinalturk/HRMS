package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.business.abstracts.VerificationCodeService;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserDao userDao;
	private VerificationCodeService verificationService;
	//private VerificationCodeDao codeDao;
	//private EmailValidationService emailValidationService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao,VerificationCodeService verificationService) {
		super();
		this.candidateDao=candidateDao;
		this.userDao=userDao;
		this.verificationService= verificationService;
		//this.codeDao = codeDao;
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
		this.verificationService.add(candidate);
		
		return new SuccessResult("Doğrulama maili gönderildi.");
	}
	@Override
	public Result update(Candidate candidate) {
		Candidate getCandidate = new Candidate();
		getCandidate=candidateDao.findById(candidate.getId()).get();
		if(candidate.getFirstName() == null || candidate.getFirstName()=="") {
			candidate.setFirstName(getCandidate.getFirstName());
		}
		if(candidate.getLastName() == null || candidate.getLastName()=="") {
			candidate.setLastName(getCandidate.getLastName());
		}
		if(candidate.getNationalIdentity() == null) {
			candidate.setNationalIdentity(getCandidate.getNationalIdentity());
		}
		if(candidate.getBirthYear() == null) {
			candidate.setBirthYear(getCandidate.getBirthYear());
		}
		if(candidate.getEmail() == null || candidate.getEmail() =="") {
			candidate.setEmail(getCandidate.getEmail());
		}
		if(candidate.getPassword() == null) {
			candidate.setPassword(getCandidate.getPassword());
		}
		if(candidate.getPhoto() == null || candidate.getPhoto() =="") {
			candidate.setPhoto(getCandidate.getPhoto());
		}
		if(candidate.getRecordTime() == null) {
			candidate.setRecordTime(getCandidate.getRecordTime());
		}
		this.candidateDao.save(candidate);
		return new SuccessResult("Kişisel bilgiler güncellendi");
	}
}
