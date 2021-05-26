package com.loteca.orangetalents.buscarapostas;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.loteca.orangetalents.novaaposta.Aposta;
import com.loteca.orangetalents.novaaposta.ApostaRepositoy;
import com.loteca.orangetalents.novaaposta.Apostador;
import com.loteca.orangetalents.novaaposta.ApostadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apostas")
@Validated
public class BuscarApostasController {

    @Autowired
    ApostadorRepository apostadorRepository;

    @Autowired
    ApostaRepositoy apostaRepositoy;

    @GetMapping
    public ResponseEntity<?> buscarApostas(
            @RequestParam @NotBlank @Email @ExistsValue(domainClass = Apostador.class, fieldName = "email") String email,
            Pageable pageable) {
                
        Apostador apostador = apostadorRepository.findByEmail(email).get();
        Page<Aposta> apostas = apostaRepositoy.findByApostador(apostador, pageable);

        return ResponseEntity.ok().body(apostas);
    }
}
