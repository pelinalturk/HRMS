package kodlamaio.Hrms.business.concretes;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployeeConfirmDao;
import kodlamaio.Hrms.entities.concretes.EmployeeConfirm;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployeeConfirmManager implements EmployeeConfirmService{

	private EmployeeConfirmDao employeeConfirmDao;
	
	@Autowired
	public EmployeeConfirmManager(EmployeeConfirmDao employeeConfirmDao) {
		super();
		this.employeeConfirmDao = employeeConfirmDao;
	}

	@Override
	public Result add(Employer employer) {
		EmployeeConfirm employeeConfirm = new EmployeeConfirm();
		employeeConfirm.setEmployee(1);
		employeeConfirm.setEmployerId(employer);
		employeeConfirm.setConfirmed(true);
		this.employeeConfirmDao.save(employeeConfirm);
		return new SuccessResult("Şirket onaylandı");
	}
}
