package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_titles")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "job_advertisements"})
public class JobPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "Pozisyon ismi boş bırakılamaz!")
	@Column(name="title")
	private String title;
	
	/*@OneToMany(mappedBy = "jobPositions") //job_id
	@JsonIgnore
	private List<JobAdvertisement> jobAdvertisements;*/
}
