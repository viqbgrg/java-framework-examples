package com.github.viqbgrg.swaggerdemo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<ResponceVo> test(){
        ResponceVo responceVo = new ResponceVo();
        return ResponseEntity.ok(responceVo);
    }
    @ApiOperation(value = "Use to get token for internal applications")
    @PostMapping(value = "/test1")
    public ResponseEntity<String> test1(@Valid @RequestBody TestDto dto) {
        return ResponseEntity.ok("success");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "登录名", value = "loginName", required = true, dataTypeClass = String.class)
    })
    @ApiOperation(value = "测试ApiImplicitParams")
    @PostMapping(value = "/test2")
    public ResponseEntity<String> test2(String loginName) {
        return ResponseEntity.ok("success");
    }


    @PostMapping(value = "/test3")
    public Result<ResponceVo> test3(){
        ResponceVo responceVo = new ResponceVo();
        return new Result<>(responceVo);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "文件1", dataType = "__file", paramType="form", required = true)
    })
    @PostMapping(value = "/file")
    public ResponseEntity<Void> file(@RequestPart(value = "文件", required = true) MultipartFile file) {
        return ResponseEntity.ok().build();
    }




    @ApiOperation(value = "测试ApiImplicitParams")
    @PostMapping(value = "/test4")
    public ResponseEntity<String> test4(@ApiParam(value = "登陆名") @RequestParam String loginName) {
        return ResponseEntity.ok("success");
    }

}
