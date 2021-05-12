package com.github.viqbgrg.webapplication.controller;

import com.github.viqbgrg.webapplication.dto.FileDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhj
 */
@RestController
@RequestMapping("file")
public class FileController {
    @PostMapping("upload")
    public String upload(FileDto fileDto) {
        String originalFilename = fileDto.getUploadFile().getOriginalFilename();
        String name = fileDto.getName();
        return name + originalFilename;
    }
}
