package kodlamaio.Hrms.entities.dtos;

import java.util.Date;

import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeignLanguageDto {
	@JsonIgnore
	private int id;
	private String language;
	private int curriculumVitaeId;
	private char languageLevel;
	@JsonIgnore
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date creationDate;
}
