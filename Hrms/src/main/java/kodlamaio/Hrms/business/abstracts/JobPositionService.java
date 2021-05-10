package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.entities.concretes.JobPositions;

public interface JobPositionService {
	List<JobPositions> getall();
}
