package in.siddharth.service;

import java.util.List;

import in.siddharth.dto.CityDto;
import in.siddharth.dto.CountryDto;
import in.siddharth.dto.QuoteApiResponseDto;
import in.siddharth.dto.ResetPwdDto;
import in.siddharth.dto.StateDto;
import in.siddharth.dto.UserDto;

public interface UserService {
	
	public List<CountryDto> getCountries();
	public List<StateDto> getStates(Integer countryId);
	public List<CityDto> getCities(Integer stateId);
	public boolean isEmailUnique(String email);
	public boolean register(UserDto userDto);
	public UserDto login(String email, String pwd);
	public boolean restPwd(ResetPwdDto resetPwdDto);
	public QuoteApiResponseDto getQuote();

}
