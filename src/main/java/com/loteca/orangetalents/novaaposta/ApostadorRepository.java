package com.loteca.orangetalents.novaaposta;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApostadorRepository extends JpaRepository<Apostador, Long>{

    Optional<Apostador> findByEmail(String email);
    
}
