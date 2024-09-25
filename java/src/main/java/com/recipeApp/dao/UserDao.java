package com.recipeApp.dao;

import com.recipeApp.model.RegisterUserDto;
import com.recipeApp.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
