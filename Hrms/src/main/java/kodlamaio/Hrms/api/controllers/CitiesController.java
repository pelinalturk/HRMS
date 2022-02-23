package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ApiOperation;
import kodlamaio.Hrms.business.abstracts.CityService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping(value = "")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
}
