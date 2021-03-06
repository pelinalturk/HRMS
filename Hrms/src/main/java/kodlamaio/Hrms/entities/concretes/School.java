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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school")
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id")
    private Candidate candidate;
	
	@NotBlank(message = "Lütfen okul ismi giriniz.")
	@Column(name = "school_name")
	private String schoolName;
	
	@ManyToOne(targetEntity = GraduateDegree.class)
	@JoinColumn(name = "graduate_degree_id",referencedColumnName = "id",nullable = false)
	private GraduateDegree degree;
	
	@NotBlank(message = "Lütfen bölümünüzü giriniz.")
	@Column(name = "school_department")
	private String schoolDepartment;
	
	@NotBlank(message = "Lütfen okula başlama tarihini giriniz.")
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@Column(name = "ending_date")
	private LocalDate endingDate;
	
	@JsonIgnore
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "creation_date")
	private Date dateOfUpload;
	
	
}
