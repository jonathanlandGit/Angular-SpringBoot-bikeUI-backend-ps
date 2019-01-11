package com.globomatics.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globomatics.bike.models.Bike;

//have to r3eplace generic with object
public interface BikeRepository extends JpaRepository<Bike, Long> {


}
