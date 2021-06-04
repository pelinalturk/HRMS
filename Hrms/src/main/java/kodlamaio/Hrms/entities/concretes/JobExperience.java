package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_experience")
public class JobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = CurriculumVitae.class)
	@JoinColumn(name = "curriculum_vitae_id")
	private CurriculumVitae cvId;
	
	@NotBlank(message = "Şirket ismi boş bırakılamaz!")
	@Column(name = "company_name")
	private String companyName;
	
	@ManyToOne(targetEntity = JobPosition.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "job_title_id",referencedColumnName = "id",nullable = false)
	private JobPosition jobTitleId;
	
	@NotBlank(message = "Lütfen işe başlama tarihini giriniz!")
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@Column(name = "ending_date")
	private LocalDate endingDate;
	
	@Column(name = "creation_date")
	private LocalDate creationDate;
	
	
}
