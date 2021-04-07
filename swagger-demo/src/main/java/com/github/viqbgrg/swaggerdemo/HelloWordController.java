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

    //    @ApiResponses(@ApiResponse(code = 200, message = "1212121212", examples = @Example(@ExampleProperty(mediaType = "application/json", value = "333331111"))))
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
}
