package kodlamaio.Hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="id")
public class Candidate extends User{
	
	@NotBlank(message= "İsim alanı boş olamaz!")
	@Column(name="first_name")
	String first_name;
	
	@NotBlank(message= "Soyisim alanı boş olamaz!")
	@Column(name="last_name")
	String last_name;
	
	@NotBlank(message= "TC kimlik numarası alanı boş olamaz!")
	@Column(name="identity_number")
	String nationalIdentity;
	
	@NotBlank(message= "Doğum yılı alanı boş olamaz!")
	@Column(name="birth_year")
	String birth_year;
}
