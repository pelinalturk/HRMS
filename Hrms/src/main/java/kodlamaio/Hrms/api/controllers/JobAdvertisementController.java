package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/JobAdvertisement")
@CrossOrigin
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
//	@GetMapping("/getall")
//	public DataResult<List<JobAdvertisement>> getAll(){
//		return this.jobAdvertisementService.getAll();
//	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) 
	{
		return this.jobAdvertisementService.add(jobAdvertisementAddDto);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrue()
	{
		return 
				this.jobAdvertisementService.findAllByIsActiveTrue();
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<JobAdvertisementDto>>findAllByIsActiveTrueOrderByCreatedDateAsc(){
		return this.jobAdvertisementService.findAllByIsActiveTrueOrderByCreatedDateAsc();
	}
	
	@GetMapping("/getByEmployer")
	public DataResult<List<JobAdvertisementDto>> getByEmployer_CompanyName(String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyName(companyName);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody JobAdvertisement jobAdvertisement)
	{
		this.jobAdvertisementService.update(jobAdvertisement);
	}
}
