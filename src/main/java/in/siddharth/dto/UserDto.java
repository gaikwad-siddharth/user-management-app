package in.siddharth.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private Integer userId;
	private String Name;
	private String email;
	private String pwd;
	private String pwdUpdated;
	private Long phno;
	
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;

}
