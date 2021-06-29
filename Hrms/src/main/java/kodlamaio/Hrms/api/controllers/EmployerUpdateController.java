package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.EmployerUpdateService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/EmployerUpdateController")
@CrossOrigin
public class EmployerUpdateController {
	EmployerUpdateService employerUpdateService;

	@Autowired
	public EmployerUpdateController(EmployerUpdateService employerUpdateService) {
		super();
		this.employerUpdateService = employerUpdateService;
	}
	@GetMapping("/getByEmployerId")
	public EmployerUpdate findByEmployer_Id(int employerId) {
		return this.employerUpdateService.findByEmployer_Id(employerId);
	}
}
