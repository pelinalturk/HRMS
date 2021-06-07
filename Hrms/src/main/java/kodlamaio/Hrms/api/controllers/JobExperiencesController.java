package kodlamaio.Hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobExperienceService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.JobExperience;
import kodlamaio.Hrms.entities.dtos.JobExperienceAddDto;
import kodlamaio.Hrms.entities.dtos.JobExperienceGetDto;

@RestController
@RequestMapping("/api/jobExperiencesController")
@CrossOrigin
public class JobExperiencesController {
	private JobExperienceService experienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperienceGetDto>> getAll(){
		return this.experienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobExperienceAddDto jobExperienceAddDto) {
		return this.experienceService.add(jobExperienceAddDto);
	}
	
	@GetMapping("/findAllByCurriculumVitaeIdOrderByEndingDateDesc")
	public DataResult<List<JobExperience>> findAllByCurriculumVitaeIdOrderByEndingDateDesc(int id) {
		return this.experienceService.findAllByCurriculumVitaeIdOrderByEndingDateDesc(id);
	}
}
