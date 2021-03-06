package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobAdvertisementConfirmEmployeeService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisementConfirmEmployee;

@RestController
@RequestMapping("/api/JobAdvConfirmEmployee")
@CrossOrigin
public class JobAdvConfirmEmployeesController {
	
	private JobAdvertisementConfirmEmployeeService confirmEmployeeService;

	@Autowired
	public JobAdvConfirmEmployeesController(JobAdvertisementConfirmEmployeeService confirmEmployeeService) {
		super();
		this.confirmEmployeeService = confirmEmployeeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisementConfirmEmployee>> findByIsActive(boolean isActive) {
		return this.confirmEmployeeService.findByIsActive(isActive);
	}
	@PostMapping("/add")
	Result add(@RequestBody JobAdvertisementConfirmEmployee jobAdvertisementConfirmEmployeeDto) {
		return this.confirmEmployeeService.add(jobAdvertisementConfirmEmployeeDto);
	}
}
