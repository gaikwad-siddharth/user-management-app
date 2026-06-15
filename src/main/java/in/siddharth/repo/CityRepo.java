package in.siddharth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.siddharth.rest.CityEntity;

public interface CityRepo extends JpaRepository<CityEntity, Integer>{

}
