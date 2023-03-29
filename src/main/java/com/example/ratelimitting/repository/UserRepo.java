package com.example.ratelimitting.repository;

import com.example.ratelimitting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    User findByEmpId(Integer empId);

}
