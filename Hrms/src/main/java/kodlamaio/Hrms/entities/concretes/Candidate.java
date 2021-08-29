package kodlamaio.Hrms.entities.concretes;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class Candidate extends User{
	
	@NotBlank(message= "İsim alanı boş olamaz!")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message= "Soyisim alanı boş olamaz!")
	@Column(name="last_name")
	private String lastName;
	
	@Size(min = 11, max = 11, message = "T.C. Kimlik numarası alanı 11 karakterden az olamaz!")
	@NotBlank(message= "TC kimlik numarası alanı boş olamaz!")
	@Column(name="identity_number")
	private String nationalIdentity;
	
	@NotNull(message= "Doğum yılı alanı boş olamaz!")
	@Column(name="birth_year")
	private LocalDate birthYear;
	
	@JsonIgnore
	@Column(name ="is_active")
	private boolean isActive=true;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<School> school;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<Technology> technology;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<ForeignLanguage> foreignLanguage;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<JobExperience> jobExperience;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<CoverLetter> coverLetter;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<SocialMedia> socialMedia;
	
	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name= "record_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date recordTime;
	
}
