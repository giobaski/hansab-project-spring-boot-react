package com.hansab.carsrestapi.controller;

import com.hansab.carsrestapi.dto.CarDto;
import com.hansab.carsrestapi.exception.CarNotFoundException;
import com.hansab.carsrestapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<CarDto> getAll(){
        return carService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable("id") Long id){
        CarDto carDto = carService.getCarById(id)
                .orElseThrow(()-> new CarNotFoundException("There is no car with ID " + id));
        return ResponseEntity.ok(carDto);
    }

}
