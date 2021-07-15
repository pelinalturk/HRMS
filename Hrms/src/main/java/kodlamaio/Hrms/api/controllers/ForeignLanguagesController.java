package kodlamaio.Hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.ForeignLanguage;
import kodlamaio.Hrms.entities.dtos.ForeignLanguageDto;

@RestController
@RequestMapping("/api/foreignLanguageController")
@CrossOrigin
public class ForeignLanguagesController {
	
	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ForeignLanguageDto>> getAll(){
		return this.foreignLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody ForeignLanguageDto foreignLanguageDto) {
		return this.foreignLanguageService.add(foreignLanguageDto);
	}
	
	@PutMapping("/{languageLevel}")
	public Result update(@PathVariable("languageLevel") int languageLevel, int id) {
		return this.foreignLanguageService.update(languageLevel, id);
	}
	
	@DeleteMapping("{id}")
	public Result delete(@PathVariable("id") int id) {
		return this.foreignLanguageService.delete(id);
	}
	@GetMapping("/getByLanguage")
	public DataResult<ForeignLanguage> getByLanguage(String language) {
		return this.foreignLanguageService.getByLanguage(language);
	}
	
	@GetMapping("/getByCandidateId")
	List<ForeignLanguage> getByCandidateId(@RequestParam int id){
		return this.foreignLanguageService.getByCandidateId(id);
	}
}
