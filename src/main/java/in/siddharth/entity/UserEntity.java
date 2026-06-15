package in.siddharth.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "USER_MASTER")
public class UserEntity {
	
	private Integer userId;
	private String Name;
	private String email;
	private String pwd;
	private String pwdUpdated;
	private Long phno;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private CountryEntity country;
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private StateEntity state;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private CityEntity city;
	
	@CreatedDate
	private LocalDate createdAt;
	
	@LastModifiedDate
	private LocalDate lastUpdatedAtDate;

}
