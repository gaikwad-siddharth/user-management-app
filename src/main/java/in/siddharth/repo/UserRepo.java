package in.siddharth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.siddharth.rest.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

}
