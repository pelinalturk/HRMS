package kodlamaio.Hrms.entities.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployerUpdateDto {
	private String companyName;
	private String webbAddress;
	private String email;
}
