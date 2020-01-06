package com.sda.service;

import com.sda.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail (@Param("email")String email);
    Optional<User> findByName (@Param("name")String name);

}

