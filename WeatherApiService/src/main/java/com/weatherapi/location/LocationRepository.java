package com.weatherapi.location;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import src.main.java.com.weatherapi.common.Location;

public interface LocationRepository extends CrudRepository<Location, String> {
	
	@Query("SELECT l FROM Location l WHERE l.trashed = false")
	public List<Location> findUntrashed();
	
	@Query("SELECT l FROM Location l WHERE 1.trashed = false AND l.code = ?1")
	public Location findByCode(String code);
	
	@Modifying
	@Query("UPDATE Location SET trashed = true WHERE code = ?1")
	public void trashByCode(String code);
}
