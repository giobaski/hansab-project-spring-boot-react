package com.hansab.carsrestapi.controller;

import com.hansab.carsrestapi.dto.CarDto;
import com.hansab.carsrestapi.dto.UserDto;
import com.hansab.carsrestapi.exception.UserNotFoundException;
import com.hansab.carsrestapi.model.User;
import com.hansab.carsrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;




    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id){
        UserDto userDto = userService.findById(id)
                .orElseThrow(()-> new UserNotFoundException("There is no user with ID " + id));
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/users/{id}/cars")
    public ResponseEntity<List<CarDto>> getCarsByUserId(@PathVariable("id") Long id){
        //TODO: implement this logic in UserService Class and return list of cars
        UserDto userDto = userService.findById(id)
                .orElseThrow(()-> new UserNotFoundException("There is no user with ID " + id));
        List<CarDto> carsDto = userDto.getCars();
        return ResponseEntity.ok(carsDto);
    }

    //TODO:for react searching component
    @GetMapping("/users/test")
    public ResponseEntity<User> filterByUser(@RequestParam("find") String username){
        System.out.println(username); //TODO:Delete this
        User user = userService.findByName(username)
                .orElseThrow(()-> new UserNotFoundException("There is no user with name " + username));
        return ResponseEntity.ok().body(user);
    }


}
