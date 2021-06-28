package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.Hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "Data Listelendi.");		
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Eklendi"); 
	}

	@Override
	public Result update(Employee employee) {
		Employee getEmployee = new Employee();
		getEmployee= employeeDao.findById(employee.getId()).get();
		if(employee.getEmail() == null || employee.getEmail() == "") {
			employee.setEmail(getEmployee.getEmail());
		}
		if(employee.getFirstName() == null || employee.getFirstName() == "") {
			employee.setFirstName(getEmployee.getFirstName());
		}
		if(employee.getLastName() == null || employee.getLastName() == "") {
			employee.setLastName(getEmployee.getLastName());
		}
		if(employee.getPassword() == null ||employee.getPassword() == "") {
			employee.setPassword(getEmployee.getPassword());
		}
		if(employee.getPhoto() == null || employee .getPhoto() == "") {	
			employee.setPhoto(getEmployee.getPhoto());
		}
		if(employee.getRecordTime() == null) {
			employee.setRecordTime(getEmployee.getRecordTime());
		}
		this.employeeDao.save(employee);
		return new SuccessResult("Bilgileriniz güncellendi.");
	}

	@Override
	public Employee findById(int id) {
		return this.employeeDao.findById(id).get();
	}

}
