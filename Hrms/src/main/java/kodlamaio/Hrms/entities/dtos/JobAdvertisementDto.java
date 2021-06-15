package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {
	private int id;
	private String employerCompanyName;
	private String jobPositionTitle;
	private int countOfOpenPosition;
	private LocalDate applicationDeadline;
	private int minWage;
	private int maxWage;
	private String cityCity;
	private String jobDetail;
	private String workingHourWorkingHour;
	private String mannerOfWorkMannerOfWork;
	private String positionLevelPositionLevel;
}
