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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "employee_confirms"})
public class Employer extends User{
	
	@NotBlank(message ="Şirket ismi alanı boş olamaz!")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message = "Web adres alanı boş olamaz!")
	@Column(name="web_address")
	private String webAddress;
	
	@NotBlank(message="Telefon numarası alanı boş olamaz!")
	@Column(name="phone_number")
	private String phoneNumber;
	
	@JsonIgnore
	//@Column(name ="is_active",columnDefinition = "true")
	@Column(name ="is_active")
	private boolean isActive;
	
	@Column(name ="is_confirm")
	private boolean isConfirm;
	
	@JsonIgnore
	@Column(name= "record_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date record_time;
	
//	@OneToMany(mappedBy = "employer") //employer_id
//	@JsonIgnore 
//	private List<JobAdvertisement>jobAdvertisements;
}
