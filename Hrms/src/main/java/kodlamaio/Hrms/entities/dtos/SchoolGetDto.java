package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolGetDto {
	@JsonIgnore
	private int id;
	
	private int curriculumVitaeId;
	private String schoolName;
	private String schoolDepartment;
	private String degreeDescription;
	private LocalDate startingDate;
	private LocalDate endingDate;
}
