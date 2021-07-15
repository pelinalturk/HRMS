package kodlamaio.Hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer>{
	boolean existsByLanguage(String language);
	ForeignLanguage getByLanguage(String language);
	List<ForeignLanguage> getByCandidateId(int id);
}
