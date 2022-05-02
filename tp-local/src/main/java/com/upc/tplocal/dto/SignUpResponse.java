package com.upc.tplocal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SignUpResponse {
    private String person_id;
    private String telephone;
    private String cellphone;
    private String email;
    private Date birth_date;
    private String surname;
    private String lastname;
    private String password;
}
