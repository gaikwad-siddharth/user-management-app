package in.siddharth.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import in.siddharth.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	public boolean existsByEmail(String email);
	
	public UserEntity findByEmailAndPwd(String email,String pwd);
	
	public UserEntity findByEmail(String email);

}
