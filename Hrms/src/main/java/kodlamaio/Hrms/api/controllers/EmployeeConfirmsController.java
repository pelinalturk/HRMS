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

import kodlamaio.Hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.EmployeeConfirm;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.dtos.EmployeeConfirmDto;

@RestController
@RequestMapping("/api/employeeConfirm")
@CrossOrigin
public class EmployeeConfirmsController {
	
	private EmployeeConfirmService employeeConfirmService;

	@Autowired
	public EmployeeConfirmsController(EmployeeConfirmService employeeConfirmService) {
		super();
		this.employeeConfirmService = employeeConfirmService;
	}
	
	@GetMapping("/getEmployeeConfirmDto")
	public DataResult<List<EmployeeConfirmDto>> findByIsActive(@RequestParam boolean isActive){
		return this.employeeConfirmService.findByIsActive(isActive);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployeeConfirm employeeConfirm) {
		return this.employeeConfirmService.add(employeeConfirm);
	}
	
}
