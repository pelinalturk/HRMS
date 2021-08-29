package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import kodlamaio.Hrms.Adapters.abstracts.CandidateCheckService;
import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.business.abstracts.VerificationCodeService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.dtos.CandidateWithCvDto;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserDao userDao;
	private VerificationCodeService verificationService;
	private CandidateCheckService candidateCheckService;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, DtoConverterService dtoConverterService, UserDao userDao,VerificationCodeService verificationService,
		@Qualifier("fakeMernis")CandidateCheckService candidateCheckService) {
		super();
		this.candidateDao=candidateDao;
		this.userDao=userDao;
		this.verificationService= verificationService;
		this.candidateCheckService=candidateCheckService;
		this.dtoConverterService= dtoConverterService;
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
		 if(this.candidateDao.findByNationalIdentity(candidate.getNationalIdentity()) != null)
		{
			return new ErrorResult("Bu T.C. Kimlik numarası sistemde kayıtlıdır!");		
		}
		 if(!this.candidateCheckService.checkCandidate(candidate)) {
			 return new ErrorResult("Kişi doğrulanamadı.");
		 }
		 if(!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			 return new ErrorResult("Şifreler uyuşmuyor.");
		 }
		 
		this.candidateDao.save(candidate);
		this.verificationService.add(candidate);
		return new SuccessResult("Doğrulama maili gönderildi.");
	}
	
	@Override
	public Result update(Candidate candidate) {//parametre olarak candidateId de gelse
		Candidate getCandidate = candidateDao.findById(candidate.getId()).get();
		//getCandidate=candidateDao.findById(candidate.getId()).get();
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
		if(candidate.getPassword() == null || candidate.getPassword()=="") {
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
	@Override
	public Candidate getById(int id) {
		return this.candidateDao.findById(id).get();
	}
	@Override
	public Result login(String email, String password) {
		if(this.candidateDao.login(email, password) == null) {
			return new ErrorResult("Email veya şifre hatalı");
		}
		return new SuccessResult("Giriş başarılı.");
	}
	@Override
	public DataResult<List<CandidateWithCvDto>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateWithCvDto>>
		(this.dtoConverterService.dtoConverter(this.candidateDao.getById(id), CandidateWithCvDto.class),"CV Bilgisi.");
	}
}
