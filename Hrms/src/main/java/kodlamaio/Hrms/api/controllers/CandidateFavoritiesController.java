package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateFavoritiesService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CandidateFavorities;

@RestController
@RequestMapping("/api/candidateFavoritiesController")
@CrossOrigin
public class CandidateFavoritiesController {
	
	private CandidateFavoritiesService candidateFavoritiesService;

	@Autowired
	public CandidateFavoritiesController(CandidateFavoritiesService candidateFavoritiesService) {
		super();
		this.candidateFavoritiesService = candidateFavoritiesService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody CandidateFavorities candidateFavorities) {
		return this.candidateFavoritiesService.add(candidateFavorities);
	}
	
	@GetMapping("/getById")
	public DataResult<List<CandidateFavorities>> getById(@RequestParam int id) {
		return this.candidateFavoritiesService.getById(id);
	}
	
	@DeleteMapping("{id}")
	public Result delete(@PathVariable("id") int id) {
		return this.candidateFavoritiesService.delete(id);
	}
}
