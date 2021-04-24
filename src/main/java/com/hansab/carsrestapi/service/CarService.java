package com.hansab.carsrestapi.service;

import com.hansab.carsrestapi.dto.CarDto;
import com.hansab.carsrestapi.model.Car;
import com.hansab.carsrestapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarDto> getAllCars(){
        return carRepository.findAll()
                .stream()
                .map(CarService::carToCarDtoConverter)
                .collect(Collectors.toList());
    }

    public Optional<CarDto> getCarById(Long id){
        return carRepository.findById(id).map(CarService::carToCarDtoConverter);
    }


    //Entity to Dto mapper
    public static CarDto carToCarDtoConverter(Car car){
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setMake(car.getMake());
        carDto.setModel(car.getModel());
        carDto.setNumberplate(car.getNumberplate());
        carDto.setUser(car.getUser().getName());
        return carDto;
    }
}


