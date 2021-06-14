package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.MannerOfWork;

public interface MannerOfWorkDao extends JpaRepository<MannerOfWork, Integer>{

}
