package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curriculum_vitae")
public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id",referencedColumnName = "id",nullable = false)
	private Candidate candidate;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "last_updated_date")
	private LocalDate lastOfUptade;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "creation_date")
	private LocalDate creationDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculumVitae")
	private List<School> school;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculumVitae")
	private List<Technology> technology;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculumVitae")
	private List<ForeignLanguage> foreignLanguage;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculumVitae")
	private List<JobExperience> jobExperience;	
}
