package com.hansab.carsrestapi.service;

import com.hansab.carsrestapi.model.Car;
import com.hansab.carsrestapi.model.User;
import com.hansab.carsrestapi.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    UserRepository userRepository = Mockito.mock(UserRepository.class);

    Car car01 = Car.builder().id(1L).make("Lada").model("2101").numberplate("123ASD").build();
    Car car02 = Car.builder().id(2L).make("Kia").model("Sorento").numberplate("534TTT").build();
    User user01 = User.builder().id(1L).name("Teet Järveküla").cars(List.of(car01,car02)).build();

    @Test
    public void getAllUsersTest(){
        Mockito.when(userRepository.findAll()).thenReturn(List.of(user01));
        Assertions.assertEquals(1, userRepository.findAll().size());
    }

    @Test
    public void findByIdTest(){
        Mockito.when(userRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(user01));
        Assertions.assertEquals("Teet Järveküla", userRepository.findById(1L).get().getName());
    }
}