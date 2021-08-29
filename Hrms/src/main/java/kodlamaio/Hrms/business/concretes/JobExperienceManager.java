package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobExperienceService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.Hrms.entities.concretes.JobExperience;
import kodlamaio.Hrms.entities.dtos.JobExperienceAddDto;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	private DtoConverterService dtoConverterService;
	private JobExperience jobExp;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.dtoConverterService=dtoConverterService;
		
	}
	
	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobExperienceAddDto jobExperienceAddDto) {
		this.jobExperienceDao.save((JobExperience) dtoConverterService.dtoClassConverter(jobExperienceAddDto, JobExperience.class));
		return new SuccessResult("Data Eklendi");
	}

	@Override
	public DataResult<List<JobExperience>> findAllByCurriculumVitaeIdOrderByEndingDateDesc(int id) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByCandidateIdOrderByEndingDateDesc(id), "İş tecrübeleri bitiş tarihlerine göre sıralandı.");
		
	}

	@Override
	public Result delete(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(JobExperience jobExperience) {
		jobExp= this.jobExperienceDao.getOne(jobExperience.getId());
		if(jobExperience.getCreationDate() == null) {jobExperience.setCreationDate(jobExp.getCreationDate());}
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Güncellendi");
	}

}
