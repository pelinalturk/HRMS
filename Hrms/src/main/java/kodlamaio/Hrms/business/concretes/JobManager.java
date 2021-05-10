package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobPositionService;
import kodlamaio.Hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.Hrms.entities.concretes.JobPositions;

@Service
public class JobManager implements JobPositionService{

	private JobPositionDao jobDao;
	
	@Autowired
	public JobManager(JobPositionDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public List<JobPositions> getall() {
		
		return this.jobDao.findAll();
	}

}
