package kodlamaio.Hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployeeConfirmDao;
import kodlamaio.Hrms.entities.concretes.EmployeeConfirm;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.dtos.EmployeeConfirmDto;

@Service
public class EmployeeConfirmManager implements EmployeeConfirmService{

	private EmployeeConfirmDao employeeConfirmDao;
	private DtoConverterService dtoConvertService;
	
	@Autowired
	public EmployeeConfirmManager(EmployeeConfirmDao employeeConfirmDao, DtoConverterService dtoConvertService) {
		super();
		this.employeeConfirmDao = employeeConfirmDao;
		this.dtoConvertService=dtoConvertService;
	}

	@Override
	public Result add(Employer employer) {
		EmployeeConfirm employeeConfirm = new EmployeeConfirm();
		//Employer employer = new Employer();
		employeeConfirm.setEmployee(1);
		employeeConfirm.setEmployer(employer);
		employeeConfirm.setConfirmed(true);
		this.employeeConfirmDao.save(employeeConfirm);
		return new SuccessResult("Şirket onaylandı");
	}

	@Override
	public DataResult<List<EmployeeConfirmDto>> findByIsActive(boolean isActive) {
		return new SuccessDataResult<List<EmployeeConfirmDto>>
		(this.dtoConvertService.dtoConverter(this.employeeConfirmDao.getByIsConfirmed(isActive), EmployeeConfirmDto.class), "Data getirildi.");
	}
}
