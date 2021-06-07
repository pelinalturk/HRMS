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

import kodlamaio.Hrms.business.abstracts.GraduateDegreeService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.GraduateDegree;

@RestController
@RequestMapping("/api/graduadeDegreeController")
@CrossOrigin
public class GraduateDegreeController {
	private GraduateDegreeService graduateDegreeService;

	@Autowired
	public GraduateDegreeController(GraduateDegreeService graduateDegreeService) {
		super();
		this.graduateDegreeService = graduateDegreeService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody GraduateDegree graduateDegree)
	{
		return this.graduateDegreeService.add(graduateDegree);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GraduateDegree>>getAll(){
		return this.graduateDegreeService.getAll();
	}
	
}
