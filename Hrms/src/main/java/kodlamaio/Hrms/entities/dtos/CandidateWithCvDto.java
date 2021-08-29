package kodlamaio.Hrms.entities.dtos;

import java.util.List;

import kodlamaio.Hrms.entities.concretes.CoverLetter;
import kodlamaio.Hrms.entities.concretes.ForeignLanguage;
import kodlamaio.Hrms.entities.concretes.JobExperience;
import kodlamaio.Hrms.entities.concretes.School;
import kodlamaio.Hrms.entities.concretes.SocialMedia;
import kodlamaio.Hrms.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateWithCvDto {
	private int id;
	private List<School> school;
	private List<Technology> technology;
	private List<ForeignLanguage> foreignLanguage;
	private List<JobExperience> jobExperience;
	private List<CoverLetter> coverLetter;
	private List<SocialMedia> socialMedia;
}
