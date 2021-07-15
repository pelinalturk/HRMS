package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceGetDto {
	@JsonIgnore
	private int id;
	
	private int candidateId;
	private String jobPositionTitle;
	private String companyName;
	private LocalDate startingDate;
	private LocalDate endingDate;
}
