package kodlamaio.Hrms.entities.dtos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementConfirmEmployeeDto {
	@JsonIgnore
	private int id;
	private int employee;
	private int jobAdvertisementId;
	//jobAdvertisement
	
	@JsonIgnore
	@Column(name = "confirm_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date confirmDate;
}
