package in.siddharth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.siddharth.rest.CountryEntity;

public interface CountryRepo extends JpaRepository<CountryEntity, Integer>{

}
