package com.loteca.orangetalents.novaaposta;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApostaRepositoy extends JpaRepository<Aposta, Long>{
    Page<Aposta> findByApostador(Apostador apostador, Pageable pageable);

    Optional<Aposta> findByNumerosAndApostador(String numerosAposta, Apostador apostador);
}
