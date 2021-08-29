package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateJobApplicationService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateJobApplicationDao;
import kodlamaio.Hrms.entities.concretes.CandidateJobApplication;

@Service
public class CandidateJobApplicationManager implements CandidateJobApplicationService{
	
	private CandidateJobApplicationDao candidateJobApplicationDao;
	
	@Autowired
	public CandidateJobApplicationManager(CandidateJobApplicationDao candidateJobApplicationDao) {
		super();
		this.candidateJobApplicationDao = candidateJobApplicationDao;
	}

	@Override
	public Result add(CandidateJobApplication candidateJobApplication) {
		if(this.candidateJobApplicationDao.existsByCandidateIdAndJobAdvertisementId(candidateJobApplication.getCandidate().getId(),candidateJobApplication.getJobAdvertisement().getId())) {
			return new ErrorResult("Başvuru değerlendirilmesi sonuçlanmadan aynı iş ilanına tekrar başvuramazsınız.");
		}
		this.candidateJobApplicationDao.save(candidateJobApplication);
		return new SuccessResult("Başvuru yapıldı.");
	}

	@Override
	public DataResult<List<CandidateJobApplication>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateJobApplication>>
		(this.candidateJobApplicationDao.getByCandidateId(id), "Data getirildi.");
	}

	@Override
	public DataResult<List<CandidateJobApplication>> getByJobAdvertisementEmployerId(int id) {
		return new SuccessDataResult<List<CandidateJobApplication>>
		(this.candidateJobApplicationDao.getByJobAdvertisementEmployerId(id),"Data getirildi.");
	}

	@Override
	public DataResult<List<CandidateJobApplication>> getByJobAdvertisementId(int id) {
		return new SuccessDataResult<List<CandidateJobApplication>>
		(this.candidateJobApplicationDao.getByJobAdvertisementId(id),"Data getirildi.");
	}

	@Override
	public boolean getByJobId(int id) {
		if(this.candidateJobApplicationDao.getByJobAdvertisement_Id(id) != null) {
			return new SuccessResult().isSuccess();
		}
		return false;
	}

	@Override
	public DataResult<List<CandidateJobApplication>> getAll() {
		return new SuccessDataResult<List<CandidateJobApplication>>(this.candidateJobApplicationDao.findAll(),"");
	}

	@Override
	public List<CandidateJobApplication> getByEmployerIdAndJobAdvertisementId(int employerId, int jobAdvertisementId) {
		return this.candidateJobApplicationDao.getByJobAdvertisementEmployerIdAndJobAdvertisementId(employerId, jobAdvertisementId);
	}

}
