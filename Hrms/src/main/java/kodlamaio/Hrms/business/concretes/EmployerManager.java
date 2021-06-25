package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.business.abstracts.VerificationCodeService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	EmployerDao employerDao;
	UserDao userDao;
	VerificationCodeService verificationCode;
	EmployeeConfirmService employeeConfirmService;
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao, VerificationCodeService verificationCodeService,EmployeeConfirmService employeeConfirmService) 
	{
		super();
		this.employerDao=employerDao;
		this.userDao = userDao;
		this.verificationCode= verificationCodeService;
		this.employeeConfirmService = employeeConfirmService;
	}
	@Override
	public DataResult<List<Employer>> getall() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi"); 
	}
	
	@Override
	public Result add(Employer employer) {
		if(this.userDao.findByEmail(employer.getEmail()) !=null) {
		return new ErrorResult("Bu mail adresi sistemde kayıtlıdır.");
		}
	   if(!employer.getWebAddress().contains(employer.getEmail().substring(employer.getEmail().indexOf("@")+1,employer.getEmail().indexOf("."))))
		{
		   return new ErrorResult("Girdiğiniz mailin şirket maili olduğuna emin olunuz!");		
		}
		else 
		{
			
			this.employerDao.save(employer);
			//this.employeeConfirmService.add(employer);
			this.verificationCode.add(employer);
			
		}
		return new SuccessResult("Email doğrulaması gönderildi.");	
	}
	@Override
	public DataResult<List<Employer>> findByIsConfirm(boolean confirm) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByIsConfirm(confirm), "Data Listelendi");
	}
	@Override
	public Employer getById(int id) {
		return this.employerDao.findById(id).get();
	}
	@Override
	public Result update(Employer employer) {
		Employer getEmployer = new Employer();
		getEmployer= employerDao.findById(employer.getId()).get();
		if(employer.getCompanyName()==null) {
			employer.setCompanyName(getEmployer.getCompanyName());
		}
		if(employer.getWebAddress()==null) {
			employer.setWebAddress(getEmployer.getWebAddress());
		}
		if(employer.getWebAddress()==null) {
			employer.setWebAddress(getEmployer.getWebAddress());
		}
		if(employer.getPhoneNumber()==null) {
			employer.setPhoneNumber(getEmployer.getPhoneNumber());
		}
		if(employer.getRecord_time()==null) {
			employer.setRecord_time(getEmployer.getRecord_time());
		}
		if(employer.getEmail()==null) {
			employer.setEmail(getEmployer.getEmail());
		}
		if(employer.getPassword()==null) {
			employer.setPassword(getEmployer.getPassword());
		}
		if(employer.getPhoto()==null) {
			employer.setPhoto(getEmployer.getPhoto());
		}
		//this.employerDao.save(employer);
		return new SuccessResult("Sistem personelinin onayından sonra bilgileriniz güncellenecektir.");
	}
}
