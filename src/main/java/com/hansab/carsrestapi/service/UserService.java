package com.hansab.carsrestapi.service;

import com.hansab.carsrestapi.dto.UserDto;
import com.hansab.carsrestapi.model.User;
import com.hansab.carsrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(UserService::userToUserDtoConverter);
    }

    public Optional<User> findByName(String username) {
        return userRepository.findByName(username);
    }


    //Entity to Dto mapper
    public static UserDto userToUserDtoConverter(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setCars(user.getCars().stream().map(CarService::carToCarDtoConverter).collect(Collectors.toList()));
        return userDto;
    }

}
