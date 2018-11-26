package com.melgar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.melgar.entities.Car;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {
	
	List<Car> findByBrand(String brand);
	
	List<Car> findByColor(String color);
	
	List<Car> findByYear(int year);
	
	@Query("Select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
}
