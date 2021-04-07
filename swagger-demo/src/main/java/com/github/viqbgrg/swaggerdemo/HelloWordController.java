package com.github.viqbgrg.swaggerdemo;

import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author hhj
 */
@RestController

public class HelloWordController {

    @PostMapping(value = "/hello")
    public ResponseEntity<String>hello(){
            return ResponseEntity.ok("Hello World");
    }

    @ApiOperation(value = "测试方法", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/test")
    public ResponceVo test(){
        ResponceVo responceVo = new ResponceVo();
        return responceVo;
    }
    @ApiOperation(value = "Use to get token for internal applications")
    @PostMapping(value = "/test1")
    public ResponseEntity<String> test1(@Valid @RequestBody TestDto dto) {
        return ResponseEntity.ok("success");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "登录名", value = "loginName", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "密码", value = "loginPwd", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = "登陆类型【0=验证码登陆、1=密码登陆】", value = "loginType", required =false, dataTypeClass = String.class),
            @ApiImplicitParam(name = "验证码", value = "smsCode", required =false, dataTypeClass = String.class),
            @ApiImplicitParam(name = "验证码", value = "storeId", required =false, dataTypeClass = String.class)
    })
    @ApiOperation(value = "测试ApiImplicitParams")
    @PostMapping(value = "/test2")
    public ResponseEntity<String> test2(String loginName) {
        return ResponseEntity.ok("success");
    }
}
