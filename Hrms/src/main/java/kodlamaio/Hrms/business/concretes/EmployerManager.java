package kodlamaio.Hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.Hrms.business.abstracts.EmployeeService;
import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.business.abstracts.VerificationCodeService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.Employee;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;
import kodlamaio.Hrms.entities.dtos.EmployerUpdateDto;

@Service
public class EmployerManager implements EmployerService{

	EmployerDao employerDao;
	UserDao userDao;
	VerificationCodeService verificationCode;
	EmployeeConfirmService employeeConfirmService;
	EmployerUpdateDao employerUpdateDao;
	EmployeeService employeeService;
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao,EmployeeService employeeService, VerificationCodeService verificationCodeService,EmployeeConfirmService employeeConfirmService, EmployerUpdateDao employerUpdateDao) 
	{
		super();
		this.employerDao=employerDao;
		this.userDao = userDao;
		this.verificationCode= verificationCodeService;
		this.employeeConfirmService = employeeConfirmService;
		this.employerUpdateDao = employerUpdateDao;
		this.employeeService = employeeService;
	
	}
	
	public boolean webAdresControl(String webAdres, String mail) {
		String[] control = mail.split("@");
		if(control[1].equals(webAdres)) {
			return true;
		}
		return false;
	}
	
	public boolean phoneNumberControl(String phoneNumber) {
		 Pattern rule =Pattern.compile("2[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
		 phoneNumber = phoneNumber.replaceAll("\\s+","");
		 Matcher control =rule.matcher(phoneNumber);
		 if(control.matches()){
	         return true;
		 }
		 return false;
	}
	
	@Override
	public DataResult<List<Employer>> getall() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi"); 
	}
	
	@Override
	public Result add(Employer employer) throws Exception {
		if(this.userDao.findByEmail(employer.getEmail()) !=null) {
		  return new ErrorResult("Bu mail adresi sistemde kayıtlıdır.");
		}
	   if(!webAdresControl(employer.getWebAddress(), employer.getEmail()))
		{
		   return new ErrorResult("Girdiğiniz mailin şirket maili olduğuna emin olunuz!");		
		}
	   if(!phoneNumberControl(employer.getPhoneNumber())) {
		   return new ErrorResult("Hatalı telefon numarası (Başında sıfır olmadığından emin olunuz.) ");
	   }
		 this.employerDao.save(employer);
		 this.verificationCode.add(employer);	
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
	public DataResult<EmployerUpdate> confirmUpdate(EmployerUpdateDto employerUpdateDto, int employerId) {
		Employer employer = getById(employerId);
		if(!webAdresControl(employerUpdateDto.getWebbAddress(), employerUpdateDto.getEmail()))
		{
		   return new ErrorDataResult<EmployerUpdate>("Girdiğiniz mailin şirket maili olduğuna emin olunuz!");		
		}
		EmployerUpdate employerUpdate = new EmployerUpdate(employerUpdateDto, employer);
		return new SuccessDataResult<EmployerUpdate>
		(this.employerUpdateDao.save(employerUpdate), "Güncelleme isteği gönderildi. Sistem onayından sonra kayıda geçecektir.");
	}
	
	@Override
	public DataResult<Employer> updateEmployer(int employeeId, int employerId) {
		Employee employee = employeeService.findById(employeeId);
		Employer employer = getById(employerId);
		EmployerUpdate employerUpdate = employerUpdateConfirm(employee, employerId);
		employer.setCompanyName(employerUpdate.getEmployerUpdateDto().getCompanyName());
		employer.setWebAddress(employerUpdate.getEmployerUpdateDto().getWebbAddress());
		employer.setEmail(employerUpdate.getEmployerUpdateDto().getEmail());
		return new SuccessDataResult<Employer>
		(employerDao.save(employer), "Güncelleme onaylandı");
	}
	
	 public EmployerUpdate employerUpdateConfirm(Employee employee, int employerId){
		 EmployerUpdate employeeUpdate = employerUpdateDao.findByEmployer_Id(employerId);
		 LocalDate now = LocalDate.now();
		 employeeUpdate.setConfirmDate(now);
		 employeeUpdate.setConfirm(true);
		 employeeUpdate.setEmployee(employee);
	     return employerUpdateDao.save(employeeUpdate);
	 }
	@Override
	public DataResult<List<Employer>> IsActiveTrueIsConfirmFalse() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByIsActiveTrueAndIsConfirmFalse(), "Onay Bekleyen İş Verenler");
	}

	@Override
	public Result login(String email, String password) {
		if(this.employerDao.login(email, password) == null) {
			return new ErrorResult("Email veya şifre hatalı");
		}
		return new SuccessResult("Giriş başarılı.");
	}

}
