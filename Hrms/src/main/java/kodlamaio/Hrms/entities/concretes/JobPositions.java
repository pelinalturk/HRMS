package kodlamaio.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_positions")
public class JobPositions {
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	
	@Column(name="position")
	private String position;
	
	@Column(name="description")
	private String description;
	
	@Column(name="employer_id")
	private int employer_id;
	
	public JobPositions() {}
	
	public JobPositions(int id, String position, String description, int employer_id) {
		super();
		this.id = id;
		this.position = position;
		this.description = description;
		this.employer_id = employer_id;
	}
	
}
