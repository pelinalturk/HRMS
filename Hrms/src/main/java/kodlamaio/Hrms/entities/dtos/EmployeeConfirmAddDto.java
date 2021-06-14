package kodlamaio.Hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeConfirmAddDto {
	@JsonIgnore
	private int id;
	private int employerId;
	private boolean isConfirmed;
}
