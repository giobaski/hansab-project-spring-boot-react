package com.hansab.carsrestapi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarDto {
    private Long id;
    private String make;
    private String model;
    private String numberplate;
    private String user;
}
