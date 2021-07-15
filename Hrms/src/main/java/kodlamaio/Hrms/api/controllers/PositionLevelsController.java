package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.PositionLevelService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.entities.concretes.PositionLevel;

@RestController
@RequestMapping("/api/positionLevel")
@CrossOrigin
public class PositionLevelsController {
	
	private PositionLevelService positionLevelService;

	@Autowired
	public PositionLevelsController(PositionLevelService positionLevelService) {
		super();
		this.positionLevelService = positionLevelService;
	}
	@GetMapping("/getAll")
	DataResult<List<PositionLevel>> getAll(){
		return this.positionLevelService.getAll();
	}
}
