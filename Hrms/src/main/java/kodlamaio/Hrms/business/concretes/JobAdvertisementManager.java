package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

//	@Override
//	public DataResult<JobAdvertisement> getByJobAdvertisementName(String name) {
//		return new SuccessDataResult<JobAdvertisement>(this.JobAdvertisementDao.getByJobAdvertisementName(name),"Data Listelendi");
//	}

}
