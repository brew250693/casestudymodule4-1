package com.codegym.casestudy.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EditProfile {
    private String email;
    private String username;
}
