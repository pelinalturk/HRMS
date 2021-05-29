package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.Hrms.entities.concretes.User;

@Repository
public interface EmailValidationDao extends JpaRepository<User, Integer>{

}
