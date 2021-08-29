package kodlamaio.Hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

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

import kodlamaio.Hrms.business.abstracts.SchoolService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.School;
import kodlamaio.Hrms.entities.dtos.SchoolAddDto;
import kodlamaio.Hrms.entities.dtos.SchoolGetDto;

@RestController
@RequestMapping("/api/schoolsController")
@CrossOrigin
public class SchoolsController {
	
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SchoolGetDto>> getAll(){
		return this.schoolService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody SchoolAddDto schoolAddDto) {
		return this.schoolService.add(schoolAddDto);
	}
	
	@GetMapping("/getBySchoolNameOrderByEndingDateDesc")
	public DataResult<List<School>> getBySchoolNameOrderByEndingDateDesc(@RequestParam int id){
		return this.schoolService.getBySchoolNameOrderByEndingDateDesc(id);
	}
	@DeleteMapping("{id}")
	public Result delete(@PathVariable("id") int id) {
		return this.schoolService.delete(id);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody SchoolAddDto schoolAddDto) {
		return this.schoolService.update(schoolAddDto);
	}
}
