package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.Hrms.entities.concretes.ForeignLanguage;
import kodlamaio.Hrms.entities.concretes.JobExperience;
import kodlamaio.Hrms.entities.concretes.School;
import kodlamaio.Hrms.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateWithCvDto {
	 @JsonIgnore
	 private int id;
	 private int candidateId;
	 private String githubLink;
	 private String linkedinLink;
	 private String photo;
	 private String description;
	 private LocalDate lastOfUptade;
//	 //private String schoolSchool;
//	// private String technology;
//	 private String foreignLanguageLanguage;
//	 //private String jobExperience;
}
