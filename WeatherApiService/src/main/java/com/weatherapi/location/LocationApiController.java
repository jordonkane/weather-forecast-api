package com.weatherapi.location;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	public ResponseEntity<Location> addLocation(@RequestBody @Valid Location location) {
		return null;}
	
	public ResponseEntity<?> listLocations() {
		return null;}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> getLocation(@PathVariable("code") String code) {
		Location location = service.get(code);
		
		if (location == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(location);
	}
	
	@PutMapping
	public ResponseEntity<?> updateLocation(@RequestBody @Valid Location location) {
		try {
			Location updatedLocation = service.update(location);
			return ResponseEntity.ok(updatedLocation);
		} catch (LocationNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{code}")
	public ResponseEntity<?> deleteLocation(@PathVariable("code") String code) {
		try {
			service.delete(code);
			return ResponseEntity.noContent().build();
		} catch (LocationNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
 