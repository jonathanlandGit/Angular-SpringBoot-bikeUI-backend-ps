package com.globomatics.bike.controllers;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesContoller {
	
	//injected bike repo here
	@Autowired
	private BikeRepository bikeRepository; 
	
	//1. List bikes
	//create a list that returns a list of bikes
	@GetMapping
	public List<Bike> list() {
		//find all records in DB table
		return bikeRepository.findAll();
	}
	
	//2. Create a bike
	//handles form creates when user submits the form
	//customerize response stawstu using annotatoin
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {
		System.out.println(bike.getName());
		bikeRepository.save(bike);
	}
	
	//3. View a specific bike

	// get a particuilar bike and return it
	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") Long id) {
		return bikeRepository.getOne(id); 
	}
	
	@DeleteMapping("/{id}")
	public void deleteBike(@PathVariable("id") Long id) {
		bikeRepository.deleteById(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@PathVariable("id") long id, @RequestBody Bike bike) {
		Bike editingBike = this.bikeRepository.getOne(id);
		
		if(editingBike == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		editingBike.setName(bike.getName());
		editingBike.setContact(bike.isContact());
		editingBike.setEmail(bike.getEmail());
		editingBike.setModel(bike.getModel());
		editingBike.setPhone(bike.getPhone());
		editingBike.setPurchaseDate(bike.getPurchaseDate());
		editingBike.setPurchasePrice(bike.getPurchasePrice());
		editingBike.setSerialNumber(bike.getSerialNumber());
		
		bike = this.bikeRepository.save(editingBike);
		
		return new ResponseEntity<Bike>(bike, HttpStatus.OK);
	}
}
