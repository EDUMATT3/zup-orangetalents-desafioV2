package com.loteca.orangetalents.novaaposta;

public class NovaApostaResponse {

    private Long id;
    private String numbers;

    public NovaApostaResponse(Aposta aposta) {
        this.id = aposta.getId();
        this.numbers = aposta.getNumbers();
    }

    public String getNumbers(){
        return this.numbers;
    }

    public Long getId(){
        return this.id;
    }
}
