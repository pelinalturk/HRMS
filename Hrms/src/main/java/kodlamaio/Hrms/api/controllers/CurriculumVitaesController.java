package kodlamaio.Hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;
import kodlamaio.Hrms.entities.dtos.CandidateWithCvDto;
import kodlamaio.Hrms.entities.dtos.CurriculumVitaeDto;

@RestController
@RequestMapping("/api/curriculumVitaesController")
@CrossOrigin
public class CurriculumVitaesController {
	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateWithCvDto>> getAll(){
		return this.curriculumVitaeService.getAll();
	}
	
	@GetMapping("/getCv")
	public DataResult<List<CurriculumVitaeDto>> getCv() {
		return this.curriculumVitaeService.getCv();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CurriculumVitae curriculumVitae) {
		return this.curriculumVitaeService.add(curriculumVitae);
	}
	
//	@GetMapping("/getCandidateCv")
//	public DataResult<List<CandidateWithCvDto>> findByCandidateId(@RequestParam int id){
//		return this.curriculumVitaeService.findByCandidateId(id);
//	}
	
	@PutMapping("/uploadImage")
	public Result saveImage(@RequestBody MultipartFile file,@RequestParam int curriculumVitaeID) {
		return this.curriculumVitaeService.saveImage(file, curriculumVitaeID);
		
	}
	
	@GetMapping("/getByCandidateId")
	CurriculumVitae getByCandidateId(int id){
		return this.curriculumVitaeService.getByCandidateId(id);
	}
}
