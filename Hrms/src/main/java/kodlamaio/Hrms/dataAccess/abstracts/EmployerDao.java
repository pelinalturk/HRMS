package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.Hrms.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer getById(int id);	
	List<Employer>findByIsConfirm(boolean confirm);
	List<Employer>findByIsActiveTrueAndIsConfirmFalse();
	@Query("From Employer where email=:email and password=:password")
	Employer login(String email, String password);
}
