package kodlamaio.Hrms.entities.dtos;

import java.util.Date;

import javax.persistence.Temporal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeignLanguageDto {
	private int id;
	private String language;
	private int curriculumVitaeId;
	@Min(1)
	@Max(5)
	private int languageLevel;
	@JsonIgnore
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date creationDate;
}
