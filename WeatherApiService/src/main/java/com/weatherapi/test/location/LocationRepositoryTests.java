package com.weatherapi.test.location;

import org.springframework.beans.factory.annotation.Autowired;

import com.weatherapi.location.LocationRepository;

import src.main.java.com.weatherapi.common.Location;

@DataJpaTests
@AutoConfigureTestDatabases(replace = Replace.NONE)
@Rollback(false)
public class LocationRepositoryTests {

	@Autowired
	private LocationRepository repository;
	
	@Test
	public void testAddSuccess() {
		Location location = new Location();
		location.setCode("NYC_USA");
		location.setCityName("New York City");
		location.setRegionName("New York");
		location.setCountryCode("US");
		location.setCountryName("United States");
		location.setEnabled(true);
		
		repository.save(location);
		
		assertThat(savedLocation).isNotNull();
		assertThat(savedLocation.getCode()).isEqualTo("NYC_USA");
	}
}
