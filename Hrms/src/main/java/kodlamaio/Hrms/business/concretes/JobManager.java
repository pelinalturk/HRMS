package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobPositionService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.Hrms.entities.concretes.JobPosition;

@Service
public class JobManager implements JobPositionService{

	private JobPositionDao jobDao;
	
	@Autowired
	public JobManager(JobPositionDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	
    @Override
	public DataResult<List<JobPosition>> getall() {
		
		return new SuccessDataResult<List<JobPosition>>
		(this.jobDao.findAll(), "İş Pozisyonları Listelendi");
				
	}
    
	@Override
	public Result add(JobPosition jobPositions) {
		if(this.jobDao.findByTitle(jobPositions.getTitle()) != null) {
			return new ErrorResult("Pozisyon ismi sistemde mevcut.");
		}
		this.jobDao.save(jobPositions);
		return new SuccessResult("Pozisyon ismi başarıyla eklendi");	
	}
}
