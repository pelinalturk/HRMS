package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.MannerOfWorkService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.entities.concretes.MannerOfWork;

@RestController
@RequestMapping("/api/mannerOfWorks")
@CrossOrigin
public class MannerOfWorksController {
	private MannerOfWorkService mannerOfWorkService;

	@Autowired
	public MannerOfWorksController(MannerOfWorkService mannerOfWorkService) {
		super();
		this.mannerOfWorkService = mannerOfWorkService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<MannerOfWork>> getAll(){
		return this.mannerOfWorkService.getAll();
	}
	
}
