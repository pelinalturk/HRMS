package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisementDto>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) 
	{
		return this.jobAdvertisementService.add(jobAdvertisementAddDto);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisementDto>> findAllByIsActive(@RequestParam boolean active)
	{
		return 
				this.jobAdvertisementService.findAllByIsActive(active);
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<JobAdvertisementDto>>findAllByIsActiveTrueOrderByCreatedDateAsc(){
		return this.jobAdvertisementService.findAllByIsActiveTrueOrderByCreatedDateAsc();
	}
	
	@GetMapping("/getByEmployer")
	public DataResult<List<JobAdvertisementDto>> getByEmployer_CompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyName(companyName);
	}
	@GetMapping("/getByEmployerId")
	public List<JobAdvertisement> getByEmployerId(@RequestParam int id) {
		return this.jobAdvertisementService.getByEmployerId(id);
	}
//	@GetMapping("/getByEmployer")
//	public List<JobAdvertisement> getByEmployer(String companyName) {
//		return this.jobAdvertisementService.getByEmployer(companyName);
//	}
	
	@GetMapping("/getByConfirm")
	public DataResult<List<JobAdvertisementDto>> findByIsConfirm(@RequestParam boolean confirm) {
		return this.jobAdvertisementService.findByIsConfirm(confirm);
	}
}
