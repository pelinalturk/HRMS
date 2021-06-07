package kodlamaio.Hrms.entities.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeConfirmDto {
	@JsonIgnore
	private int id;
	private int employee;
	private String employerCompanyName;
	private String employerWebAddress;
	private String employerEmail;
	private String employerPhoneNumber;
	private boolean isConfirmed;
	private Date confirmDate;
}
