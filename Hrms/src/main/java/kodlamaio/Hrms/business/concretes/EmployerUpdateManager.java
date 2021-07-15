package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerUpdateService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService{

	EmployerUpdateDao updateDao;
	
	@Autowired
	public EmployerUpdateManager(EmployerUpdateDao updateDao) {
		super();
		this.updateDao = updateDao;
	}

	@Override
	public EmployerUpdate findByEmployer_Id(int employerId) {
		return this.updateDao.findByEmployer_Id(employerId);
	}

	@Override
	public DataResult<List<EmployerUpdate>> findByIsConfirmFalse() {
		return new SuccessDataResult<List<EmployerUpdate>>
		(this.updateDao.findByIsConfirmFalse(), "Güncelleme Talebi Bekleyen İş Verenler");
	}

}
