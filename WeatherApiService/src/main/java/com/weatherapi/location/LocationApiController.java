package com.weatherapi.location;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.weatherapi.common.Location;

@RestController
@RequestMapping("/v1/locations")
public class LocationApiController {

	private LocationService service;

	public LocationApiController(LocationService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Location> addLocation(Location location){
		Location addedLocation = service.add(location);
		URI uri = URI.create("/v1/locations/" + location.getCode());
		
		return ResponseEntity.created(uri).body(addedLocation);
	}
	
	@GetMapping
	public ResponseEntity<?> listLocations() {
		List<Location> locations  = service.list();
		
		if (locations.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(locations);
	}
}
 