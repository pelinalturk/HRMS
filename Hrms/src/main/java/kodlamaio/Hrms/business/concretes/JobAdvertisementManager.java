package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao JobAdvertisementDao;
	private ModelMapper modelMapper;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, DtoConverterService dtoConverterService,ModelMapper modelMapper) {
		super();
		JobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper = modelMapper;
		this.dtoConverterService=dtoConverterService;
	}

	private JobAdvertisement dtoConverter(JobAdvertisementAddDto jobAdvertisementAddDto){
		return modelMapper.map(jobAdvertisementAddDto, JobAdvertisement.class);
		
	}
//	@Override
//	public DataResult<List<JobAdvertisementDto>> getAll() {
//		
//		return new SuccessDataResult<List<JobAdvertisement>>(this.JobAdvertisementDao.findAll(),"Data Listelendi");
//	}
	
	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		
		 this.JobAdvertisementDao.save(dtoConverter(jobAdvertisementAddDto));
		 return new SuccessResult("Eklendi");
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(dtoConverterService.dtoConverter(JobAdvertisementDao.findByIsActiveTrue(),JobAdvertisementDto.class));
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
	
}
