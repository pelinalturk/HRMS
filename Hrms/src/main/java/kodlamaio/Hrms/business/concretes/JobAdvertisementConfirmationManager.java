package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobAdvertisementConfirmEmployeeService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertisementConfirmEmployeeDao;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import kodlamaio.Hrms.entities.concretes.JobAdvertisementConfirmEmployee;

@Service
public class JobAdvConfirmEmployeeManager implements JobAdvertisementConfirmEmployeeService{

	private JobAdvertisementConfirmEmployeeDao dao;
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvConfirmEmployeeManager(JobAdvertisementConfirmEmployeeDao dao, JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.dao = dao;
		this.jobAdvertisementDao= jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisementConfirmEmployee confirmJob) {
		if(dao.existsByJobAdvertisement_Id(confirmJob.getJobAdvertisement().getId())) {
			return new ErrorResult("İş İlanı daha önce onaylandı.");
		}
		JobAdvertisement advertisement = new JobAdvertisement();
		advertisement = jobAdvertisementDao.getById(confirmJob.getJobAdvertisement().getId());
		advertisement.setConfirm(true);
		jobAdvertisementDao.save(advertisement);
		dao.save(confirmJob);
		 //this.dao.save((JobAdvertisementConfirmEmployee) dtoConverterService.dtoClassConverter(jobAdvertisementConfirmEmployeeDto, JobAdvertisementConfirmEmployee.class) );
		return new SuccessResult("İlan onaylandı");
	}

	

	@Override
	public DataResult<List<JobAdvertisementConfirmEmployee>> findByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisementConfirmEmployee>> (this.dao.getByIsConfirmed(isActive) ,"İlanları listelendi");
		//(this.dtoConverterService.dtoConverter(this.dao.getByIsConfirmed(isActive), JobAdvertisementConfirmEmployeeDto.class), "Data getirildi.");
	}
}
