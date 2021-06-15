package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.PositionLevelService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.dataAccess.abstracts.PositionLevelDao;
import kodlamaio.Hrms.entities.concretes.PositionLevel;

@Service
public class PositionLevelManager implements PositionLevelService{

	private PositionLevelDao positionLevelDao;
	
	@Autowired
	public PositionLevelManager(PositionLevelDao positionLevelDao) {
		super();
		this.positionLevelDao = positionLevelDao;
	}

	@Override
	public DataResult<List<PositionLevel>> getAll() {
		return new SuccessDataResult<List<PositionLevel>>(this.positionLevelDao.findAll(), "Data Listelendi");
	}

}
