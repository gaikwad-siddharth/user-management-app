package in.siddharth.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.siddharth.dto.CityDto;
import in.siddharth.dto.CountryDto;
import in.siddharth.dto.StateDto;
import in.siddharth.dto.UserDto;
import in.siddharth.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserResrController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/countries")
	public ResponseEntity<List<CountryDto>> getCountries(){
		List<CountryDto> countries = userService.getCountries();
		return new ResponseEntity<>(countries, HttpStatus.OK);
	}
	
	@GetMapping("/states/{countryId}")
	public ResponseEntity<List<StateDto>> getStates(@PathVariable Integer countryId){
		List<StateDto> states = userService.getStates(countryId);
		return new ResponseEntity<>(states, HttpStatus.OK);
	}
	
	@GetMapping("/cities/{stateId}")
	public ResponseEntity<List<CityDto>> getCities(@PathVariable Integer stateId){
		List<CityDto> states = userService.getCities(stateId);
		return new ResponseEntity<>(states, HttpStatus.OK);
	}
	
	public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
		boolean register = userService.register(userDto);
		if(register) {
			return new ResponseEntity<>("Regsitration Sucess", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Regsitration Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> login(@RequestBody UserDto userDto){
		UserDto user = userService.login(userDto.getEmail(), userDto.getPwd());
		if(user != null)  {
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
								.body("Invalid Credentials");
		}
	}

}
