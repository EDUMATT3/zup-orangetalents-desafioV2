package com.loteca.orangetalents.novaaposta;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApostaServiceTest {

    private ApostaRepositoy apostaRepositoy = mock(ApostaRepositoy.class);
    Lotto lotto = mock(Lotto.class);
    private ApostaService apostaService = new ApostaService(lotto, apostaRepositoy);

    @Test
    @DisplayName("Não salvar um número para um mesmo apostador caso já exista")
    void test1()  throws Exception {
        Apostador apostador = new Apostador("email");
        Aposta apostaEsperada = new Aposta("1-2-3-4-5-7", apostador);

        when(lotto.randomBet())
        .thenReturn("1-2-3-4-5-6")
        .thenReturn("1-2-3-4-5-7");

        when(apostaRepositoy.findByNumerosAndApostador("1-2-3-4-5-6", apostador)).thenReturn(Optional.of(new Aposta()));
        when(apostaRepositoy.findByNumerosAndApostador("1-2-3-4-5-7", apostador)).thenReturn(Optional.empty());
        when(apostaRepositoy.save(any(Aposta.class))).thenReturn(apostaEsperada);

        Aposta apostaAtual = apostaService.salvarNovaAposta(apostador);

        verify(apostaRepositoy, times(2)).findByNumerosAndApostador(anyString(), any(Apostador.class));
        Assertions.assertEquals(apostaEsperada, apostaAtual);

    }
    
}
