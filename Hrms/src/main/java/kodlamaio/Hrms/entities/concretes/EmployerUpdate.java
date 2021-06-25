package kodlamaio.Hrms.entities.concretes;

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
import springfox.documentation.spring.web.json.Json;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "employer_update")
//public class EmployerUpdate {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;
//	
//	@ManyToOne
//	@JoinColumn(name = "employer_id")
//	private Employer employer;
//	
//	@Column(name = "employee_id")
//	private int employee;
//	
//	@Column(name = "data")
//	private String data;
//	
//	@Column(name = "is_confirm")
//	private boolean isConfirm =false;
//	
//	@JsonIgnore
//	@Column(name= "confirm_date")
//	@CreationTimestamp
//	@Temporal(javax.persistence.TemporalType.DATE)
//	private Date confirmDate;
//}
