package kodlamaio.Hrms.entities.dtos;

import java.util.List;
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
	private int id;
	private int candidateId;
	private String githubLink;
	private String linkedinLink;
	private String photo;
	private String description;
	private List<School> school;
	private List<Technology> technology;
	private List<ForeignLanguage> foreignLanguage;
	private List<JobExperience> jobExperience;
}
