package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateFavoritiesService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
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
		if(candidateFavoritiesDao.existsByJobAdvertisement_Id(candidateFavorities.getJobAdvertisement().getId())) {
			return new ErrorResult("İş ilanı daha önce favoriler kısmına eklenmişti.");
		}
		this.candidateFavoritiesDao.save(candidateFavorities);
		return new SuccessResult("Data Eklendi");
	}

	@Override
	public DataResult<List<CandidateFavorities>> getById(int id) {
		return new SuccessDataResult<List<CandidateFavorities>>(this.candidateFavoritiesDao.getByCandidateId(id), "Data Listelendi");
	}

	@Override
	public Result delete(int id) {
		this.candidateFavoritiesDao.deleteById(id);
		return new SuccessResult("Favorilerden kaldırıldı.");
	}

}
