package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
import kodlamaio.Hrms.entities.dtos.JobAdvertisementsFilterDto;

@RestController
@RequestMapping("/api/JobAdvertisement")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
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
	@GetMapping("/getByActiveAndConfirm")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndIsConfirmTrue() {
		return this.jobAdvertisementService.findByIsActiveTrueAndIsConfirmTrue();
	}
	
	@GetMapping("/activeTrue")
	public List<JobAdvertisement> activeTrue(int pageNo, int pageSize) {
		return this.jobAdvertisementService.activeTrue( pageNo,  pageSize);
	}
	
	@GetMapping("/getByConfirm")
	public DataResult<List<JobAdvertisementDto>> findByIsConfirm(@RequestParam boolean confirm) {
		return this.jobAdvertisementService.findByIsConfirm(confirm);
	}
	
	@GetMapping("/getById")
	public JobAdvertisement getById(int id) {
		return this.jobAdvertisementService.getById(id);
	}
	
	@GetMapping("/getByPage")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndIsConfirmTrue(int pageNo, int pageSize) {
		return this.jobAdvertisementService.findByIsActiveTrueAndIsConfirmTrue(pageNo, pageSize);
	}
	
	@GetMapping("/getByPositionLevel")
	public DataResult<List<JobAdvertisement>> getByPositionLevelId(int id) {
		return this.jobAdvertisementService.getByPositionLevelId(id);
	}
	
	@GetMapping("/getByJobPosition")
	public DataResult<List<JobAdvertisement>> getByJobPositionId(int id) {
		return this.jobAdvertisementService.getByJobPositionId(id);
	}
	
	@PostMapping("/getByFilter")
	 public Result getByFilterJob(@RequestParam int pageNo,@RequestParam int pageSize,@RequestBody JobAdvertisementsFilterDto jobAdvertisementFilter){
		 return jobAdvertisementService.getByFilterJob(pageNo,pageSize,jobAdvertisementFilter);
	 }
	 
	 @PostMapping("/changeIsConfirm")
	 public Result isActiveChange(@RequestParam int id) {
		 return this.jobAdvertisementService.isActiveChange(id);
	 }
}
