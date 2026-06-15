package in.siddharth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.siddharth.entity.CountryEntity;

public interface CountryRepo extends JpaRepository<CountryEntity, Integer>{

}
