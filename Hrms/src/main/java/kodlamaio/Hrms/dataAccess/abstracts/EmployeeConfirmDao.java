package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.EmployeeConfirm;

public interface EmployeeConfirmDao extends JpaRepository<EmployeeConfirm, Integer>{
	//onaylanan employerlar ve onaylanmayan employerlar için ayrıayır getall
	List<EmployeeConfirm> getByIsConfirmed(boolean isActive);
	boolean existsByEmployer_Id(int id);
}
