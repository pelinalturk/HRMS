package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.WorkingHourService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.dataAccess.abstracts.WorkingHourDao;
import kodlamaio.Hrms.entities.concretes.WorkingHour;

@Service
public class WorkingHourManager implements WorkingHourService{

	private WorkingHourDao workingHourDao;
	
	@Autowired
	public WorkingHourManager(WorkingHourDao workingHourDao) {
		super();
		this.workingHourDao = workingHourDao;
	}

	@Override
	public DataResult<List<WorkingHour>> getAll() {
		return new SuccessDataResult<List<WorkingHour>>(this.workingHourDao.findAll(), "Data Listelendi");
	}

}
