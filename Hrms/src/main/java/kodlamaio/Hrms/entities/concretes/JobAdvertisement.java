package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@Column(name = "job_detail")
	private String jobDetail;
	
	@Column(name = "min_wage")
	private int minWage;
	
	@Column(name = "max_wage")
	private int maxWage;
	
	@Column(name = "count_of_open_position")
	private int countOfOpenPosition;
	
	@JsonIgnore
	@Column(name = "created_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date createdDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;
}
