package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateJobApplicationService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CandidateJobApplication;

@RestController
@RequestMapping("/api/candidateJobApplicationsController")
@CrossOrigin
public class CandidateJobApplicationsController {
	
	private CandidateJobApplicationService candidateJobApplicationService;

	@Autowired
	public CandidateJobApplicationsController(CandidateJobApplicationService candidateJobApplicationService) {
		super();
		this.candidateJobApplicationService = candidateJobApplicationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateJobApplication candidateJobApplication) {
		return this.candidateJobApplicationService.add(candidateJobApplication);
	}
	
	@GetMapping("/GetAll")
	public DataResult<List<CandidateJobApplication>> getByCandidateId(@RequestParam int id) {
		return this.candidateJobApplicationService.getByCandidateId(id);
	}
	
	@GetMapping("/getByEmployer")
	public DataResult<List<CandidateJobApplication>> getByJobAdvertisementEmployerId(int id) {
		return this.candidateJobApplicationService.getByJobAdvertisementEmployerId(id);
	}
	
	@GetMapping("/getByJobAdvertisementId")
	public DataResult<List<CandidateJobApplication>> getByJobAdvertisementId(int id) {
		return this.candidateJobApplicationService.getByJobAdvertisementId(id);
	}
}
