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

import kodlamaio.Hrms.business.abstracts.CoverLetterService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CoverLetter;
import kodlamaio.Hrms.entities.dtos.CoverLetterAddDto;

@RestController
@RequestMapping("/api/coverLetterController")
@CrossOrigin
public class CoverLettersController {
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@GetMapping("/getByCandidateId")
	public List<CoverLetter> getByCandidateId(@RequestParam int id) {
		return this.coverLetterService.getByCandidateId(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterAddDto coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}
	
	@DeleteMapping("{id}")
	public Result delete(@PathVariable("id") int id) {
		return this.coverLetterService.delete(id);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CoverLetterAddDto coverLetter) {
		return this.coverLetterService.update(coverLetter);
	}
}
