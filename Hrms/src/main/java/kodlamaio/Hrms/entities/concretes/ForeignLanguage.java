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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foreign_language")
public class ForeignLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@NotBlank(message = "Dil alanı boş geçilemez!")
	@Column(name = "language")
	private String language;
	
	@JsonIgnore
	@Column(name = "creation_date")
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date creationDate;
	
	@Min(1)
	@Max(5)
	@Column(name = "level")
	private int languageLevel;	
}
