package com.github.viqbgrg.springboottesting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LoginDto {
    private String username;
    private String password;
}
