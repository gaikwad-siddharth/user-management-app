package in.siddharth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.siddharth.rest.StateEntity;

public interface StateRepo extends JpaRepository<StateEntity, Integer>{

}
