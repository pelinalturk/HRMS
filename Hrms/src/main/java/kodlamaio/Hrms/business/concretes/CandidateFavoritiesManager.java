package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateFavoritiesService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateFavoritiesDao;
import kodlamaio.Hrms.entities.concretes.CandidateFavorities;

@Service
public class CandidateFavoritiesManager implements CandidateFavoritiesService{
	
	private CandidateFavoritiesDao candidateFavoritiesDao;
	
	@Autowired
	public CandidateFavoritiesManager(CandidateFavoritiesDao candidateFavoritiesDao) {
		super();
		this.candidateFavoritiesDao = candidateFavoritiesDao;
	}

	@Override
	public Result add(CandidateFavorities candidateFavorities) {
		this.candidateFavoritiesDao.save(candidateFavorities);
		return new SuccessResult("Data Eklendi");
	}

	@Override
	public DataResult<List<CandidateFavorities>> getAll() {
		return new SuccessDataResult<List<CandidateFavorities>>(this.candidateFavoritiesDao.findAll(), "Data Listelendi");
	}

}
