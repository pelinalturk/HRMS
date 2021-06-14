package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
}
