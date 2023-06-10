package com.weatherapi.location;

import org.springframework.stereotype.Service;

import src.main.java.com.weatherapi.common.Location;

@Service
public class LocationService {

	private LocationRepository repo;
	
	public LocationService(LocationRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Location add(Location location) {
		return repo.save(location);	
	}
}
