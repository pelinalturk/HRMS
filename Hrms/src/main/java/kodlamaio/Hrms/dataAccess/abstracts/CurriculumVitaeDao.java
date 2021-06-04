package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.Hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer>{
/*
 * Adayların okudukları okullar mezuniyet yılına
 *  göre tersten sıralanabilmelidir. Mezun olunmamışsa yine bu okul en üstte ve "devam ediyor" 
 *  olarak görüntülenmelidir.*/
	
	//List<CurriculumVitae> findBySchool_EndingDateDesc();
	
	/*Adayların 
	 * tecrübeleri yıla göre tersten sıralanabilmelidir. Hala çalışıyorsa yine bu tecrübesi en üstte ve 
	 * "devam ediyor" olarak görüntülenmelidir.*/
	//List<CurriculumVitae> findByJobExperience_StartingDateDesc();
	//List<CurriculumVitae> findByCandidateId(int id);
	//önce cv
	
}
