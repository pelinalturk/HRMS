package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobExperienceService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobExperiencesController")
public class JobExperiencesController {
	private JobExperienceService experienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll(){
		return this.experienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(JobExperience jobExperience) {
		return this.experienceService.add(jobExperience);
	}
}
