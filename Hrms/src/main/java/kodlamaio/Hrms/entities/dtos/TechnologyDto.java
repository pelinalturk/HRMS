package kodlamaio.Hrms.entities.dtos;

import java.util.Date;

import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDto {
	
	private int id;
	private int curriculumVitaeId;
	@NotBlank(message = "Boş alan bırakmayınız")
	private String description;
	@JsonIgnore
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date creationDate;
}
