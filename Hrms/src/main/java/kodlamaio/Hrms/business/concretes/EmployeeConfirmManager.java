package kodlamaio.Hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployeeConfirmDao;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.EmployeeConfirm;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.dtos.EmployeeConfirmDto;

@Service
public class EmployeeConfirmManager implements EmployeeConfirmService{

	private EmployeeConfirmDao employeeConfirmDao;
	private EmployerDao employerDao;
	private DtoConverterService dtoConvertService;
	
	@Autowired
	public EmployeeConfirmManager(EmployeeConfirmDao employeeConfirmDao, DtoConverterService dtoConvertService, EmployerDao employerDao) {
		super();
		this.employeeConfirmDao = employeeConfirmDao;
		this.dtoConvertService=dtoConvertService;
		this.employerDao=employerDao;
	}

	@Override
	public Result add(EmployeeConfirm employeeConfirm) {
		if(employeeConfirmDao.existsByEmployer_Id(employeeConfirm.getEmployer().getId())) {
			return new ErrorResult("Şirket daha önce onaylandı.");
		}
		Employer employer = new Employer();
		employer = employerDao.getById(employeeConfirm.getEmployer().getId());
		employer.setConfirm(true);
		employerDao.save(employer);
		employeeConfirmDao.save(employeeConfirm);
		return new SuccessResult("Şirket onaylandı");
	}

	@Override
	public DataResult<List<EmployeeConfirmDto>> findByIsActive(boolean isActive) {
		return new SuccessDataResult<List<EmployeeConfirmDto>>
		(this.dtoConvertService.dtoConverter(this.employeeConfirmDao.getByIsConfirmed(isActive), EmployeeConfirmDto.class), "Data getirildi.");
	}
}
