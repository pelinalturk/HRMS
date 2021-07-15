package kodlamaio.Hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;
import kodlamaio.Hrms.entities.dtos.EmployerUpdateDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	private EmployerService employerService;
	
	
	@Autowired
	public EmployersController(EmployerService employerService)
	{
		super();
		this.employerService=employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getall();
	}
	
	@GetMapping("/getByConfirm")
	public DataResult<List<Employer>> findByIsConfirm(boolean confirm) {
		return this.employerService.findByIsConfirm(confirm);
	}
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
	
	@GetMapping("/getById")
	public Employer getById(@RequestParam int id) {
		return this.employerService.getById(id);
	}
	
	@PostMapping("/update")//güncelleme isteği
	public DataResult<EmployerUpdate> confirmUpdateEmployer(@Valid @RequestBody EmployerUpdateDto employerUpdateDto, @RequestParam int employerId){
		return employerService.confirmUpdate(employerUpdateDto, employerId);
	}
	
	@PostMapping("/update/confirm")//onay
	public DataResult<Employer> updateEmployer(@RequestParam int employeeId, @RequestParam int employerId){
		return employerService.updateEmployer(employeeId, employerId);
	}
	
	@GetMapping("/IsActiveTrueIsConfirmFalse")
	public DataResult<List<Employer>> IsActiveTrueIsConfirmFalse() {
		return this.employerService.IsActiveTrueIsConfirmFalse();
	}
	
	@GetMapping("/login")
	public Result login(@RequestParam String email, @RequestParam String password) {
		return this.employerService.login(email, password);
	}
}
