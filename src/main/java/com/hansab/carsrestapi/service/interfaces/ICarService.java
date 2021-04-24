package com.hansab.carsrestapi.service.interfaces;

import com.hansab.carsrestapi.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarService {

    List<CarDto> getAllCars();
    Optional<CarDto> getCarById(Long id);
}
