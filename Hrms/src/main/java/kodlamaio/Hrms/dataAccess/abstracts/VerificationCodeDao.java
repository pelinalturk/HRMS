package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kodlamaio.Hrms.entities.concretes.VerificationCode;

@Repository
public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer>{
	
}
