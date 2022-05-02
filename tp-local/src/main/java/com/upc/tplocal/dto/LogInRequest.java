package com.upc.tplocal.dto;

import lombok.Data;

@Data
public class LogInRequest {
    private String person_id;
    private String password;
}
