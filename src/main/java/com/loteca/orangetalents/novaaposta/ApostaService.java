package com.loteca.orangetalents.novaaposta;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ApostaService {
    
    private Lotto lotto;
    private ApostaRepositoy apostaRepositoy;

    public ApostaService(Lotto lotto, ApostaRepositoy apostaRepositoy) {
        this.lotto = lotto;
        this.apostaRepositoy = apostaRepositoy;
    }

    public Aposta salvarNovaAposta(Apostador apostador){
        String numerosAposta = generaValidNumbers(apostador);
        Aposta novaAposta = new Aposta(numerosAposta, apostador);
        return apostaRepositoy.save(novaAposta);
    }

    private String generaValidNumbers(Apostador apostador){
        String numerosAposta;
        Optional<Aposta> possivelAposta;

        do {
            numerosAposta = lotto.randomBet();
            possivelAposta = apostaRepositoy.findByNumerosAndApostador(numerosAposta, apostador);
        } while (possivelAposta.isPresent());

        return numerosAposta;
    }
}
