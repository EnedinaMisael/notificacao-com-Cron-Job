package com.eneds.first_spring_app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// para gerar automaticamente os getters, setters e construtor

public class User {
    private String name;
    private String email;
}
