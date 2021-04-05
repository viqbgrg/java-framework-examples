package com.github.viqbgrg.swaggerdemo;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
    @GetMapping(value = "/hello")
//    @ApiResponses(@ApiResponse(code = 200, message = "1212121212", examples = @Example(@ExampleProperty(mediaType = "application/json", value = "333331111"))))
    public ResponseEntity<String>hello(){
            return ResponseEntity.ok("Hello World");
    }
}
