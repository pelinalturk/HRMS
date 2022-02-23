package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.Hrms.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
