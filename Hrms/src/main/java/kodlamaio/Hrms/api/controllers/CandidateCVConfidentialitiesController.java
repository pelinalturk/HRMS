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

import kodlamaio.Hrms.business.abstracts.CandidateCVConfidentialityService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCVConfidentiality;

@RestController
@RequestMapping("/api/CandidateCVConfidentialitiesController")
@CrossOrigin
public class CandidateCVConfidentialitiesController {
	
	private CandidateCVConfidentialityService candidateCVConfidentialityService;

	@Autowired
	public CandidateCVConfidentialitiesController(CandidateCVConfidentialityService candidateCVConfidentialityService) {
		super();
		this.candidateCVConfidentialityService = candidateCVConfidentialityService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCVConfidentiality candidateCVConfidentiality) {
		return this.candidateCVConfidentialityService.add(candidateCVConfidentiality);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<CandidateCVConfidentiality> getByCandidateId(@RequestParam int id) {
		return this.candidateCVConfidentialityService.getByCandidateId(id);
	}

	@GetMapping("/getByConfidentialityTrue")
	public List<CandidateCVConfidentiality> getByConfidentialityTrue() {
		return this.candidateCVConfidentialityService.getByConfidentialityTrue();
	}
}
