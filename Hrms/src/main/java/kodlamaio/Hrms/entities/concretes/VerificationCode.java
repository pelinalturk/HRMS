package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="verification_codes")
public class VerificationCode {
	
	@Id
	@GeneratedValue
	@Column(name ="id")
	private int id;
	
	@Column(name ="code")
	private String code;
	
	@Column(name ="is_verified")
	private boolean is_verified;
	
	@Column(name= "verified_date")
	private LocalDate verified_date;
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name ="user_id", nullable = false)
	private int user_id;
}
