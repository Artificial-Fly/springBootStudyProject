package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    //SQL Query
    @Query(value = "SELECT * FROM users WHERE email=:email", nativeQuery = true)
    Optional<User> findByEmail(@Param(value = "email") String email);
    //JP Query
//    @Query(value = "SELECT u FROM User u WHERE u.email=:email")
//    User findByEmail(@Param(value="email") String email);
    //JP Method
//    User findByEmailAndAgeAfterAndBirth(String email, Integer age, LocalDate birth);
}
