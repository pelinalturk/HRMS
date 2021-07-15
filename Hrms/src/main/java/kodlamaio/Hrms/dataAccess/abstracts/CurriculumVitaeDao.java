package kodlamaio.Hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer>{
	 
	//List<CurriculumVitae>getByCandidateId(int id);
	//List<CurriculumVitae>getBySchool
	CurriculumVitae getByCandidateId(int id);
}
