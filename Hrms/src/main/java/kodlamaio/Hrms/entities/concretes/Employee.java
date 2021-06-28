package kodlamaio.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@Column(name ="is_active")
	private boolean isActive = true;
	
	@JsonIgnore
	@Column(name= "record_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date recordTime;
}
