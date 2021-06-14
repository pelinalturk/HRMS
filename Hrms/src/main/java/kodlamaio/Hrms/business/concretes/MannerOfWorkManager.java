package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.MannerOfWorkService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.dataAccess.abstracts.MannerOfWorkDao;
import kodlamaio.Hrms.entities.concretes.MannerOfWork;

@Service
public class MannerOfWorkManager implements MannerOfWorkService{

	private MannerOfWorkDao mannerOfWorkDao;
	
	@Autowired
	public MannerOfWorkManager(MannerOfWorkDao mannerOfWorkDao) {
		super();
		this.mannerOfWorkDao = mannerOfWorkDao;
	}

	@Override
	public DataResult<List<MannerOfWork>> getAll() {
		return new SuccessDataResult<List<MannerOfWork>>(this.mannerOfWorkDao.findAll(), "Data Listelendi");
	}

}
