package com.melgar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melgar.entities.Car;
import com.melgar.repositories.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	
	@GetMapping("/cars")
	public Iterable<Car> getCars(){
		return carRepository.findAll();
	}
}
