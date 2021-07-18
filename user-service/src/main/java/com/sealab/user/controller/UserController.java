package com.sealab.user.controller;

import com.sealab.user.VO.ResponseTemplateVO;
import com.sealab.user.entity.User;
import com.sealab.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside saveUser");
        return userService.saveUser(user);
    }

//    @GetMapping("/{userId}")
//    public User getUserById(@PathVariable("userId") Long userId){
//
//        return userService.getUserById(userId);
//    }

    @GetMapping("/{userId}")
    public ResponseTemplateVO getUserWithDepartmentById(@PathVariable("userId") Long userId){

        return userService.getUserWithDepartmentById(userId);
    }

}
