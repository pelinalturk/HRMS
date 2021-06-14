package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.WorkingHourService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.entities.concretes.WorkingHour;

@RestController
@RequestMapping("/api/workingHours")
@CrossOrigin
public class WorkingHoursController {
	private WorkingHourService workingHourService;

	@Autowired
	public WorkingHoursController(WorkingHourService workingHourService) {
		super();
		this.workingHourService = workingHourService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<WorkingHour>> getAll(){
		return this.workingHourService.getAll();
	}
}
