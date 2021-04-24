package com.hansab.carsrestapi.repository;

import com.hansab.carsrestapi.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameStartingWith(String name, Sort sort);
}
