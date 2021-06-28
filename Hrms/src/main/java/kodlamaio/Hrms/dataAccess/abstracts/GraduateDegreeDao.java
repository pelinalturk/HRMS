package kodlamaio.Hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.entities.concretes.GraduateDegree;

public interface GraduateDegreeDao extends JpaRepository<GraduateDegree, Integer>{
	boolean existsByDescription(String graduate);
	List<GraduateDegree> findById(int id);
}
