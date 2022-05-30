package com.oasis.postnet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInRequest {
    @NotBlank
    private String dni;
    @NotBlank
    private String password;

}
