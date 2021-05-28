package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao JobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		JobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		 this.JobAdvertisementDao.save(jobAdvertisement);
		 return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.JobAdvertisementDao.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.JobAdvertisementDao.getByIsActive(),"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndCreatedDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "createdDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.JobAdvertisementDao.findAll(sort),"Başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.JobAdvertisementDao.getByEmployer_CompanyName(companyName), "Data Listelendi");
	}

}
