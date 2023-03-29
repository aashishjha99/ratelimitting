package com.example.ratelimitting.controller;

import com.example.ratelimitting.model.UserDao;
import com.example.ratelimitting.service.implementation.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    private final UserServiceImpl userService;
    private final RateLimiterRegistry rateLimiterRegistry;

    public UserController(UserServiceImpl userService, RateLimiterRegistry rateLimiterRegistry) {
        this.userService = userService;
        this.rateLimiterRegistry = rateLimiterRegistry;
    }

    @PostMapping(value = "/save")
    @RateLimiter(name = "default", fallbackMethod = "rateLimiterFallbackForSaving")
    public ResponseEntity<String> save(@RequestBody UserDao userDao) {
        return ResponseEntity.ok(userService.save(userDao));
    }

    @GetMapping(value = "/{empid}")
    @RateLimiter(name = "apiconfigured", fallbackMethod = "rateLimiterFallback")
    public ResponseEntity<UserDao> getUser(@PathVariable String empid) {
        log.info("current thread {}", Thread.currentThread().getName());
        return ResponseEntity.ok(userService.getUser(empid));
    }


    public ResponseEntity<String> rateLimiterFallback(Exception e) {
        return new ResponseEntity<String>("Service is down", HttpStatus.TOO_MANY_REQUESTS);

    }

    public ResponseEntity<String> rateLimiterFallbackForSaving(Exception e) {
        return new ResponseEntity<String>("Service is down unable to save data", HttpStatus.TOO_MANY_REQUESTS);

    }
}

