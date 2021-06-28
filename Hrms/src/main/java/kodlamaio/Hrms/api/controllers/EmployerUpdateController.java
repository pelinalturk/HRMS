package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.EmployerUpdateService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/employerUpdateController")
public class EmployerUpdateController {
	private EmployerUpdateService employerUpdateService;

	@Autowired
	public EmployerUpdateController(EmployerUpdateService employerUpdateService) {
		super();
		this.employerUpdateService = employerUpdateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerUpdate employerUpdate) {
		return this.employerUpdateService.add(employerUpdate);
	}
	
}
