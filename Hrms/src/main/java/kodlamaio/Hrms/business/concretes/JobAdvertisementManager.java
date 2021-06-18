package kodlamaio.Hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.Hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.Hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao JobAdvertisementDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, DtoConverterService dtoConverterService) {
		super();
		JobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		
		 this.JobAdvertisementDao.save((JobAdvertisement) dtoConverterService.dtoClassConverter(jobAdvertisementAddDto, JobAdvertisement.class) );
		 return new SuccessResult("Eklendi");
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> findAllByIsActive(boolean active) {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(dtoConverterService.dtoConverter(JobAdvertisementDao.findByIsActive(active),JobAdvertisementDto.class));
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> getByEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.dtoConverterService.dtoConverter(this.JobAdvertisementDao.getByEmployer_CompanyName(companyName),JobAdvertisementDto.class), "Şirket ismine göre listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrueOrderByCreatedDateAsc() {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.dtoConverterService.dtoConverter(this.JobAdvertisementDao.findByIsActiveTrueOrderByCreatedDateAsc(),JobAdvertisementDto.class), "Aktif iş ilanları oluşturulma tarihine göre listelendi.");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.JobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("güncellendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAll() {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.dtoConverterService.dtoConverter(this.JobAdvertisementDao.findAll(),JobAdvertisementDto.class),"Data Listelendi");
	}

	@Override
	public JobAdvertisement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsConfirm( boolean confirm) {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(dtoConverterService.dtoConverter(JobAdvertisementDao.findByIsConfirm(confirm),JobAdvertisementDto.class));
	}

	@Override
	public List<JobAdvertisement> getByEmployerId(int id) {
		return this.JobAdvertisementDao.getByEmployer_Id(id);
	}


	
}
