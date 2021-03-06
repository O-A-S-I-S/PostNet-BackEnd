package com.api.postnet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInResponse {
    private Long id;
    private String dni;
    private String surname;
    private String lastName;
    private String email;
    private String password;
}
