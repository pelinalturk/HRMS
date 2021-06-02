package kodlamaio.Hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.GraduateDegree;

public interface GraduateDegreeDao extends JpaRepository<GraduateDegree, Integer>{
	//boolean existByDescription(String graduate);
}
