package com.hansab.carsrestapi.service;

import com.hansab.carsrestapi.dto.UserDto;
import com.hansab.carsrestapi.model.User;
import com.hansab.carsrestapi.repository.UserRepository;
import com.hansab.carsrestapi.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(UserService::userToUserDtoConverter).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(UserService::userToUserDtoConverter);
    }


    @Override
    public List<UserDto> findUsersAndSort(String prefix, String sortingField, String sortingOrder) {

        Sort sort = Sort.by(sortingOrder.equalsIgnoreCase("ASC")? Sort.Direction.ASC : Sort.Direction.DESC,
                "name");

        return userRepository.findByNameStartingWith(prefix, sort).stream()
                .map(UserService::userToUserDtoConverter)
                .collect(Collectors.toList());
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
