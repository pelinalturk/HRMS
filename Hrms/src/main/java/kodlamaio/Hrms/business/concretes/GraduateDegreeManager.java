package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.GraduateDegreeService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.GraduateDegreeDao;
import kodlamaio.Hrms.entities.concretes.GraduateDegree;

@Service
public class GraduateDegreeManager implements GraduateDegreeService{

	private GraduateDegreeDao graduateDegreeDao;
	
	@Autowired
	public GraduateDegreeManager(GraduateDegreeDao graduateDegreeDao) {
		super();
		this.graduateDegreeDao = graduateDegreeDao;
	}

	@Override
	public DataResult<List<GraduateDegree>> getAll() {
		
		return new SuccessDataResult<List<GraduateDegree>>(this.graduateDegreeDao.findAll(), "true");
	}

	@Override
	public Result add(GraduateDegree graduateDegree) {
	//	if (graduateDegreeDao.existByDescription(graduateDegree.getDescription())) {
		//	return  new ErrorResult("Daha önce eklendi");
		//}
		this.graduateDegreeDao.save(graduateDegree);
		return  new SuccessResult("Eklendi");
	}
}
