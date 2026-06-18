package in.siddharth.service;

import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.siddharth.dto.CityDto;
import in.siddharth.dto.CountryDto;
import in.siddharth.dto.QuoteApiResponseDto;
import in.siddharth.dto.ResetPwdDto;
import in.siddharth.dto.StateDto;
import in.siddharth.dto.UserDto;
import in.siddharth.entity.CityEntity;
import in.siddharth.entity.CountryEntity;
import in.siddharth.entity.StateEntity;
import in.siddharth.entity.UserEntity;
import in.siddharth.repo.CityRepo;
import in.siddharth.repo.CountryRepo;
import in.siddharth.repo.StateRepo;
import in.siddharth.repo.UserRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	
	private final EmailService emailService;
	
	@Autowired
	private CountryRepo countryRepo;
	
	@Autowired
	private StateRepo stateRepo;
	
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public List<CountryDto> getCountries() {
		List<CountryEntity> countries =countryRepo.findAll();
		
		return countries.stream()
		.map(country -> mapper.map(country, CountryDto.class))
		.toList();
	}

	@Override
	public List<StateDto> getStates(Integer countryId) {
		List<StateEntity> states = stateRepo.findByCountryCountryId(countryId);
		return states.stream()
				.map(state -> mapper.map(state, StateDto.class))
				.toList();
	}

	@Override
	public List<CityDto> getCities(Integer stateId) {
		List<CityEntity> cities = cityRepo.findByStateStateId(stateId);
		return cities.stream()
				.map(city -> mapper.map(city, CityDto.class))
				.toList();
	}

	@Override
	public boolean isEmailUnique(String email) {
		return !userRepo.existsByEmail(email);
	}

	@Override
	public boolean register(UserDto userDto) {
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		
		String randomPwd = genrateRandomPwd(5);
		
		userEntity.setPwd(randomPwd);
		userEntity.setPwdUpdated("NO");
		
		System.out.println("CountryId = " + userDto.getCountryId());
		System.out.println("StateId = " + userDto.getStateId());
		System.out.println("CityId = " + userDto.getCityId());
		
		CountryEntity countryEntity = countryRepo.findById(userDto.getCountryId()).orElseThrow();
		StateEntity stateEntity = stateRepo.findById(userDto.getStateId()).orElseThrow();
		CityEntity cityEntity = cityRepo.findById(userDto.getCityId()).orElseThrow();
		
		userEntity.setCountry(countryEntity);
		userEntity.setState(stateEntity);
		userEntity.setCity(cityEntity);
		
		UserEntity savedUser = userRepo.save(userEntity);
		
		if(savedUser.getUserId() != null) {
			String subject = "Your Account Created";
			String body = "<h1>Your Login Password: " + randomPwd + "</h1>";
			emailService.sendEmail(subject, body, userDto.getEmail());
			
			return true;
		}
		return false;
	}
	
	private String genrateRandomPwd(int pwdLength) {
		
		Random random = new Random();
		
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		
		StringBuffer buffer = new StringBuffer(pwdLength);
		
		for(int i=0; i< pwdLength; i++) {
			int randomIndex = random.nextInt(chars.length());
			char charAt =chars.charAt(randomIndex);
			buffer.append(charAt);
		}
		return buffer.toString();
	}

	@Override
	public UserDto login(String email, String pwd) {
		
		UserEntity userEntity = userRepo.findByEmailAndPwd(email, pwd);
		
		if(userEntity != null) {
			return mapper.map(userEntity, UserDto.class);
		}

		return null;
	}

	@Override
	public boolean restPwd(ResetPwdDto resetPwdDto) {
		
		UserEntity userEntity = userRepo.findByEmail(resetPwdDto.getEmail());
		
		if(userEntity!=null) {
			userEntity.setPwd(resetPwdDto.getNewPwd());
			userEntity.setPwdUpdated("YES");
			userRepo.save(userEntity);   
			return true;
		}
		return false;
	}

	@Override
	public QuoteApiResponseDto getQuote() {
		
		String apiUrl = "https://dummyjson.com/quotes/random";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<QuoteApiResponseDto> forEntity = rt.getForEntity(apiUrl, QuoteApiResponseDto.class);
		return forEntity.getBody();
	}

}
