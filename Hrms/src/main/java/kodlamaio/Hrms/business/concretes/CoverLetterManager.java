package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CoverLetterService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.Hrms.entities.concretes.CoverLetter;
import kodlamaio.Hrms.entities.dtos.CoverLetterAddDto;

@Service
public class CoverLetterManager implements CoverLetterService{
	private CoverLetterDao coverLetterDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao, DtoConverterService dtoConverterService) {
		super();
		this.coverLetterDao = coverLetterDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(CoverLetterAddDto coverLetter) {
		 this.coverLetterDao.save((CoverLetter) dtoConverterService.dtoClassConverter(coverLetter, CoverLetter.class));
		return new SuccessResult("Ön yazı eklendi.");
	}

	@Override
	public Result delete(int id) {
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("Data silindi.");
	}

	@Override
	public List<CoverLetter> getByCandidateId(int id) {
		return this.coverLetterDao.getByCandidateId(id);
	}

	@Override
	public Result update(CoverLetterAddDto coverLetter) {
		 this.coverLetterDao.save((CoverLetter) dtoConverterService.dtoClassConverter(coverLetter, CoverLetter.class));
		 return new SuccessResult("Güncellendi.");
	}
	
}
