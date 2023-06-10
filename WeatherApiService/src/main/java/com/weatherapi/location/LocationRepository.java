package com.weatherapi.location;

import org.springframework.data.repository.CrudRepository;

import src.main.java.com.weatherapi.common.Location;

public interface LocationRepository extends CrudRepository<Location, String> {

}
