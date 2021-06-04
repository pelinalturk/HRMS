package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {
	private String employerCompanyName;
	private String jobPositionTitle;
	private int countOfOpenPosition;
	private LocalDate applicationDeadline;
}
