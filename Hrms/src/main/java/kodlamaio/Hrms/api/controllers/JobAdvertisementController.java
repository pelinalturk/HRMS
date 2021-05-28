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
	public DataResult<List<JobAdvertisement>> getByIsActive()
	{
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<JobAdvertisement>>getByIsActiveAndCreatedDate(){
		return this.jobAdvertisementService.getByIsActiveAndCreatedDate();
	}
//	@GetMapping("/getByJobAdvertisementName")
//	public DataResult<JobAdvertisement> getByJobAdvertisementName(String name)
//	{
//		return this.jobAdvertisementService.getByJobAdvertisementName(name);
//	}
}
