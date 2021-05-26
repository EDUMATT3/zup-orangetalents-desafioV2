package com.loteca.orangetalents.novaaposta;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NovaApostaRequestTest{

    private NovaApostaRequest request = new NovaApostaRequest("email@email.com");
    private ApostadorRepository apostadorRepository = mock(ApostadorRepository.class);

    @Test
    @DisplayName("Cria um apostador caso ele não exista")
    void test1()  throws Exception {
        when(apostadorRepository.findByEmail("email@email.com")).thenReturn(Optional.empty());
        when(apostadorRepository.save(any())).thenReturn(new Apostador("email@email.com"));

        Apostador novoApostador = request.toModel(apostadorRepository);

        Assertions.assertNotNull(novoApostador);
        verify(apostadorRepository).save(any(Apostador.class));
    }

    @Test
    @DisplayName("Retorna um apostador caso ele exista")
    void test2()  throws Exception {
        when(apostadorRepository.findByEmail("email@email.com")).thenReturn(Optional.of(new Apostador("email@email.com")));
        
        Apostador novoApostador = request.toModel(apostadorRepository);

        Assertions.assertNotNull(novoApostador);
        verify(apostadorRepository, never()).save(any(Apostador.class));
    }
}