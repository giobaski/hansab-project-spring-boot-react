package com.hansab.carsrestapi.controller;

import com.hansab.carsrestapi.dto.CarDto;
import com.hansab.carsrestapi.dto.UserDto;
import com.hansab.carsrestapi.exception.UserNotFoundException;
import com.hansab.carsrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


//    @GetMapping("/users")
//    public List<UserDto> getAll(){
//        return userService.getAllUsers();
//    }

    //1. get all users 2. search and filter by query params
    @GetMapping(value= "/users")
    public ResponseEntity<List<UserDto>> filterByUserAndSort(@RequestParam(value = "find", required = false) Optional<String> name,
                                                             @RequestParam(value = "sort", required = false) Optional<String> sorting ) {
        if(name.isEmpty()){
            List<UserDto> users =  userService.getAllUsers();
            return ResponseEntity.ok().body(users);
        }else{
            String[] sortiongOptions = sorting.get().split(":");   // fieldname:asc or fieldname:desc
            String sortingField = sortiongOptions[0];               // fieldname
            String sortingOrder = sortiongOptions[1].toUpperCase(); // ASC or DESC

            List<UserDto> users = userService.findUsersAndSort(name.get(), sortingField, sortingOrder);
            return ResponseEntity.ok().body(users);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id){
        UserDto userDto = userService.findById(id)
                .orElseThrow(()-> new UserNotFoundException("There is no user with ID " + id));
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/users/{id}/cars")
    public ResponseEntity<List<CarDto>> getCarsByUserId(@PathVariable("id") Long id){
        UserDto userDto = userService.findById(id)
                .orElseThrow(()-> new UserNotFoundException("There is no user with ID " + id));
        List<CarDto> carsDto = userDto.getCars();
        return ResponseEntity.ok().body(carsDto);
    }

}
