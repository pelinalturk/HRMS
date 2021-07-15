package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolGetDto {
	
	private int id;
	
	private int candidateId;
	private String schoolName;
	private String schoolDepartment;
	private String degreeDescription;
	private LocalDate startingDate;
	private LocalDate endingDate;
}
