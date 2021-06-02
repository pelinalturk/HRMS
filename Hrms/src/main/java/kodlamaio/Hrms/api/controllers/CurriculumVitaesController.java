package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumVitaesController")
public class CurriculumVitaesController {
	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumVitaeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(CurriculumVitae curriculumVitae) {
		return this.curriculumVitaeService.add(curriculumVitae);
	}
	
	@GetMapping("/findAllByendingDateDesc")
	public List<CurriculumVitae> findAllByendingDateDesc(){
		return this.curriculumVitaeService.findAllByendingDateDesc();
	}
	
	@GetMapping("findAllByJobExperience_StartingDateDesc")
	public List<CurriculumVitae> findAllByJobExperience_StartingDateDesc(){
		return this.curriculumVitaeService.findAllByJobExperience_StartingDateDesc();
	}
}
