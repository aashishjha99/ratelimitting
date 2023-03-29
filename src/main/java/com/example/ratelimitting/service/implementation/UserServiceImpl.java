package com.example.ratelimitting.service.implementation;


import com.example.ratelimitting.entity.User;
import com.example.ratelimitting.model.UserDao;
import com.example.ratelimitting.repository.UserRepo;
import com.example.ratelimitting.service.UserService;
import com.example.ratelimitting.status.Status;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;

  @Override
  public String save(UserDao user) {

    Optional<User> userOut = Optional.of(userRepo.save(User.builder().mobileNumber(user.getMobileNumber())
        .motherName(user.getMotherName()).fatherName(user.getFatherName()).adderess(user.getAdderess())
        .pinCode(user.getPinCode()).empId(user.getEmpId()).name(user.getName()).build()));
    return userOut.isPresent() ? Status.SUCCESS.toString() : Status.FAILURE.toString();
  }

  @Override
  public UserDao getUser(String username) {

    User user = userRepo.findByEmpId(Integer.parseInt(username));
    if (!Objects.isNull(user)) {

      return UserDao.builder().mobileNumber(user.getMobileNumber()).adderess(user.getAdderess())
          .motherName(user.getMotherName()).fatherName(user.getFatherName()).pinCode(user.getPinCode())
          .empId(user.getEmpId()).name(user.getName()).build();

    }
    return UserDao.builder().build();

  }
}
