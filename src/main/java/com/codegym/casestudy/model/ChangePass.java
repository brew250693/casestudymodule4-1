package com.codegym.casestudy.model;

import lombok.Data;

@Data
public class ChangePass {
    private String oldPassword;
    private String newPassword;
    private String confirm;
}
