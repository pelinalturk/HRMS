package kodlamaio.Hrms.entities.concretes;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "techs")
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = CurriculumVitae.class)
	@JoinColumn(name = "curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
	
	@NotBlank(message = "Açıklama kısmı boş geçilemez.")
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@Column(name = "creation_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date creationDate;
}
