package in.siddharth.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.siddharth.entity.CityEntity;

public interface CityRepo extends JpaRepository<CityEntity, Integer>{
	
	public List<CityEntity> findByStateStateId(Integer stateId);

}
