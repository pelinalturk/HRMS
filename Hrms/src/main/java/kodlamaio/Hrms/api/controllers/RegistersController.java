package kodlamaio.Hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.RegisterEmployerService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Employer;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegistersController {
	
	private final RegisterEmployerService registerEmployerService;
	
	@PostMapping(value = "/employer")
    public Result registerEmployer(@Valid @RequestBody Employer employer) throws Exception {
        return registerEmployerService.registerEmployer(employer);
    }
}
