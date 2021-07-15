package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer>{
	EmployerUpdate findByEmployer_Id(int employerId);
	EmployerUpdate findByEmployer_IdAndIsConfirm(int employerId, boolean isConfirmed);
	List<EmployerUpdate> findByIsConfirmFalse();
}
