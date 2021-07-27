package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import kodlamaio.Hrms.entities.dtos.EmployerUpdateDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employer_update")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class EmployerUpdate{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@Column(name = "is_confirm")
	private boolean isConfirm =false;
	
	@Column(name= "confirm_date")
	private LocalDate confirmDate;
	
	 @Type(type = "jsonb")
	    @Column(columnDefinition = "jsonb")
	    private EmployerUpdateDto employerUpdateDto;
	 
	 public EmployerUpdate(EmployerUpdateDto employerUpdateDto, Employer employer) {
	        this.employerUpdateDto = employerUpdateDto;
	        this.employer = employer;
	    }
}
