package kodlamaio.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "employee_confirms"})
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends User{
	
	@NotBlank(message = "İsim alanı boş bırakılamaz!")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Soyisim alanı boş bırakılamaz!")
	@Column(name = "last_name")
	private String lastName;
}
