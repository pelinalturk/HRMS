package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.PositionLevel;

public interface PositionLevelDao extends JpaRepository<PositionLevel, Integer>{

}
