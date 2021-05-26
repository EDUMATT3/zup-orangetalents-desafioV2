package com.loteca.orangetalents.novaaposta;

import java.util.Objects;
import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

public class NovaApostaRequest {

    @NotBlank
    @Email
    private String email;

    ////Por algum motivo o compilador não criou um construtor vazio
    @Deprecated
    public NovaApostaRequest(){}

    public NovaApostaRequest(@NotNull @Email String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public Apostador toModel(ApostadorRepository apostadorRepository) {
        Assert.state(Objects.nonNull(apostadorRepository), "ApostadorRepository não deveria ser nulo");
        Assert.hasLength(email, "Email não deveria ser nulo");

        Optional<Apostador> possivelApostador = apostadorRepository.findByEmail(this.email);

        if(possivelApostador.isPresent()) 
            return possivelApostador.get();

        Apostador novoApostador = new Apostador(email);
        
        return apostadorRepository.save(novoApostador);
    }
}
