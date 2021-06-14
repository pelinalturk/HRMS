package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementAddDto {
	@JsonIgnore
	private int id;
	private int employerId;
	private int jobPositionId;
	private int countOfOpenPosition;
	private int minWage;
	private int maxWage;
	private int cityId;
	private String jobdetail;
	private LocalDate createdDate;
	private LocalDate applicationDeadline;
	private int workingHourId;
	private int mannerOfWorkId;
	
}
