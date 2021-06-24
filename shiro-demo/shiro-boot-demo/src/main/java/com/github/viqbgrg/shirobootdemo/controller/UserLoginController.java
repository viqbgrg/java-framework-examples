package com.github.viqbgrg.shirobootdemo.controller;


import com.github.viqbgrg.shirobootdemo.domain.dto.UserSignInDto;
import com.github.viqbgrg.shirobootdemo.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author hhj
 */
@RestController
@RequestMapping("login")
public class UserLoginController {
    private IUserService userService;

    public UserLoginController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册
     * @param userSignInDto
     * @return
     */
    @PostMapping("signIn")
    public ResponseEntity<Void> signIn(@Valid @RequestBody UserSignInDto userSignInDto){
        userService.signIn(userSignInDto);
        return ResponseEntity.ok().build();
    }
}
