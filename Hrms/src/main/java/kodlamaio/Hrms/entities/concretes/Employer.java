package kodlamaio.Hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name="id")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "job_advertisements"})
public class Employer extends User{
	
	@NotBlank(message ="Şirket ismi alanı boş olamaz!")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message = "Web adres alanı boş olamaz!")
	@Column(name="web_address")
	private String web_address;
	
	@NotBlank(message="Telefon numarası alanı boş olamaz!")
	@Column(name="phone_number")
	private String phone_number;
	
	@JsonIgnore
	@Column(name ="is_active",columnDefinition = "true")
	@Getter
	private boolean is_active = true;
	
	@JsonIgnore
	@Column(name= "record_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date record_time;
	
	//@OneToMany(mappedBy = "employer") //employer_id
	//private List<JobAdvertisement>jobAdvertisements;
}
