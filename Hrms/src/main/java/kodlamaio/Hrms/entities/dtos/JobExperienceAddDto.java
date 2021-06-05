package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceAddDto {
	@JsonIgnore
	private int id;
	
	private int curriculumVitaeId;
	
	private int jobPositionId;
	
	@NotBlank(message = "Şirket ismi boş bırakılamaz!")
	private String companyName;
	private LocalDate startingDate;
	private LocalDate endingDate;
}
