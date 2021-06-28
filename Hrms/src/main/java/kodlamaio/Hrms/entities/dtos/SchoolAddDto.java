package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;
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
public class SchoolAddDto {
	
	private int id;
	
	private int curriculumVitaeId;
	private String schoolName;
	private int degreeId;
	private String schoolDepartment;
	private LocalDate startingDate;
	private LocalDate endingDate;
	
	@JsonIgnore
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateOfUpload;
}
