package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "educations")
public class Education {
//	@Id
//	@Column(name = "id")
//	private int id;
//	
//	@Column(name = "edu_name")
//	private String eduName;
//	
//	@ManyToOne(targetEntity = City.class)
//	@JoinColumn(name = "city_id",referencedColumnName = "id",nullable = false)
//	private City cityId;
//	
//	@ManyToMany
//	@JoinTable(name = "educations_education_department", 
//	joinColumns =  @JoinColumn(name = "edu_id"), 
//	inverseJoinColumns = @JoinColumn(name ="edu_department_id"))
//	List<EducationDepartment> eduDepartment;
}
