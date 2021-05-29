package kodlamaio.Hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/JobAdvertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) 
	{
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveTrue()
	{
		return 
				this.jobAdvertisementService.findAllByIsActiveTrue();
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<JobAdvertisement>>findAllByIsActiveTrueOrderByCreatedDateAsc(){
		return this.jobAdvertisementService.findAllByIsActiveTrueOrderByCreatedDateAsc();
	}
	
	@GetMapping("/getByEmployer")
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyName(companyName);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody JobAdvertisement jobAdvertisement)
	{
		this.jobAdvertisementService.update(jobAdvertisement);
	}
}
