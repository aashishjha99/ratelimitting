package com.example.ratelimitting.service;



import com.example.ratelimitting.model.UserDao;

import java.util.Optional;

public interface UserService {

    String save(UserDao User);

    UserDao getUser(String username);
}
