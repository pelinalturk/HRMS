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

import kodlamaio.Hrms.business.abstracts.TechnologyService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.dtos.TechnologyDto;

@RestController
@RequestMapping("/api/technologiesController")
@CrossOrigin
public class TechnologiesController {
	
	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<TechnologyDto>> getAll(){
		return this.technologyService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody TechnologyDto technologyDto) {
		return this.technologyService.add(technologyDto);
	}
}
