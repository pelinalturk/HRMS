package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerUpdateService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService{

	EmployerUpdateDao updateDao;
	EmployerDao employerDao;
	
	@Autowired
	public EmployerUpdateManager(EmployerUpdateDao updateDao, EmployerDao employerDao) {
		super();
		this.updateDao = updateDao;
		this.employerDao = employerDao;
	}

	@Override
	public Result add(EmployerUpdate employerUpdate) {
//		Employer getEmployer = new Employer();
//		getEmployer= employerDao.findById(employerUpdate.getId()).get();
//		if(employerUpdate.getCompanyName()==null) {
//			employerUpdate.setCompanyName(getEmployer.getCompanyName());
//		}
//		if(employerUpdate.getWebAddress()==null) {
//			employerUpdate.setWebAddress(getEmployer.getWebAddress());
//		}
//		if(employerUpdate.getWebAddress()==null) {
//			employerUpdate.setWebAddress(getEmployer.getWebAddress());
//		}
//		if(employerUpdate.getPhoneNumber()==null) {
//			employerUpdate.setPhoneNumber(getEmployer.getPhoneNumber());
//		}
////		if(employerUpdate.getConfirmDate()==null) {
////			employerUpdate.setRecord_time(getEmployer.getRecord_time());
////		}
//		if(employerUpdate.getEmail()==null) {
//			employerUpdate.setEmail(getEmployer.getEmail());
//		}
//		if(employerUpdate.getPassword()==null) {
//			employerUpdate.setPassword(getEmployer.getPassword());
//		}
//		if(employerUpdate.getPhoto()==null) {
//			employerUpdate.setPhoto(getEmployer.getPhoto());
//		}
		updateDao.save(employerUpdate);
		return new SuccessResult("Güncelleme isteği gönderildi. Onaylandıktan sonra sisteme işlenecektir.");
	}

	@Override
	public Result confirm(int employeeId, boolean confirm, Employer employer) {
		if(confirm) {
			//setle
		}
		updateDao.save(null);
		return new SuccessResult();
	}

}
