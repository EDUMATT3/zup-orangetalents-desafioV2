package com.loteca.orangetalents.novaaposta;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Aposta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String numeros;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Apostador apostador;

    @Deprecated
    public Aposta(){}

    public Aposta(@NotBlank String numeros,@NotNull Apostador apostador) {
        this.numeros = numeros;
        this.apostador = apostador;
    }

    public String getNumbers() {
        return this.numeros;
    }

    public Long getId() {
        return this.id;
    }
}
