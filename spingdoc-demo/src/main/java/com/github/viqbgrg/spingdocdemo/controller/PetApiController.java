package com.github.viqbgrg.spingdocdemo.controller;

import com.github.viqbgrg.spingdocdemo.model.Dog;
import com.github.viqbgrg.spingdocdemo.model.Person;
import com.github.viqbgrg.spingdocdemo.model.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PetApiController {

    @GetMapping
    @Operation(summary = "summary", operationId = "operationId", description = "description")
    public Result<String> getString() {
        return null;
    }


    @GetMapping("/person")
    @Operation(summary = "summary-Person", operationId = "operationId-Person", description = "description-Person")
    public Result<Person> getPerson() {
        return null;
    }

    @GetMapping("/dog")
    @Operation(summary = "summary-dog", operationId = "operationId-dog", description = "description-dog")
    public Result<Dog> getDog() {
        return null;
    }

    @GetMapping("/dogList")
    @Operation(summary = "summary-dog-list", operationId = "operationId-dog-list", description = "description-dog-list")
    public List<Dog> getDogList() {
        return null;
    }

}
