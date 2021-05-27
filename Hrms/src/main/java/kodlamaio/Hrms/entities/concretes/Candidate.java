package kodlamaio.Hrms.entities.concretes;


import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
	private String first_name;
	
	@NotBlank(message= "Soyisim alanı boş olamaz!")
	@Column(name="last_name")
	private String last_name;
	
	@Size(min = 11, max = 11, message = "T.C. Kimlik numarası alanı 11 karakterden az olamaz!")
	@NotBlank(message= "TC kimlik numarası alanı boş olamaz!")
	@Column(name="identity_number")
	private String nationalIdentity;
	
	@NotNull(message= "Doğum yılı alanı boş olamaz!")
	@Column(name="birth_year")
	private LocalDate birth_year;
	
	@JsonIgnore
	@Column(name ="is_active",columnDefinition = "true")
	@Getter
	private boolean is_active = true;
	
	@JsonIgnore
	@Column(name= "record_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date record_time;
	
}
