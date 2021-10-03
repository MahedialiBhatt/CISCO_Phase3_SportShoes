package com.sportyShoes.service;

import org.springframework.data.repository.CrudRepository;

import com.sportyShoes.model.User;

public interface userRepository extends CrudRepository<User, Integer> 
{
     User findByEmail(String username);
}
