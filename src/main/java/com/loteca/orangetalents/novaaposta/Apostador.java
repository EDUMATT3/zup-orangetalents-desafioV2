package com.loteca.orangetalents.novaaposta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Apostador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotBlank @Email String email;

    @Deprecated
    public Apostador(){};

    public Apostador(@NotBlank @Email String email) {
        this.email = email;
    }

}
