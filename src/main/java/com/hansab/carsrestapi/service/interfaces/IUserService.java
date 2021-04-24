package com.hansab.carsrestapi.service.interfaces;

import com.hansab.carsrestapi.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserDto> getAllUsers();
    Optional<UserDto> findById(Long id);
    List<UserDto> findUsersAndSort(String prefix, String sortingField, String sortingOrder);

}
