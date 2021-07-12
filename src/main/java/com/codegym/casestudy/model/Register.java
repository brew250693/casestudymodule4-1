package com.codegym.casestudy.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Register {
    private String username;
    private String email;
    private String password;
    private String confirm;
}
