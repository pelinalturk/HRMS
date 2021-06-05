package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	List<School> findAllByCurriculumVitaeIdOrderByEndingDateDesc(int id);
}
