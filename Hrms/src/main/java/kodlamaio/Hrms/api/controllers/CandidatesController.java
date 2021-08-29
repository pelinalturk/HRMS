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

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.dtos.CandidateWithCvDto;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService)
	{
		super();
		this.candidateService=candidateService;
	}
	@GetMapping("/getall")
	public List<Candidate> getAll()
	{
		return this.candidateService.getall();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
		
	}
	
	@PostMapping("/update")
	public Result update( @RequestBody Candidate candidate) {
		return this.candidateService.update(candidate);
	}
	
	@GetMapping("/getById")
	public Candidate getById(@RequestParam int id) {
		return this.candidateService.getById(id);
	}
	
	@GetMapping("/login")
	public Result login(@RequestParam String email, @RequestParam String password) {
		return this.candidateService.login(email, password);
	}
	
	@GetMapping("getCv")
	public DataResult<List<CandidateWithCvDto>> getByCandidateId(@RequestParam int id) {
		return this.candidateService.getByCandidateId(id);
	}
}
