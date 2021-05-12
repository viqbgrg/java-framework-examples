package com.github.viqbgrg.webapplication.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hhj
 */
@Data
public class FileDto {
    private MultipartFile uploadFile;
    private String name;
}
