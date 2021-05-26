package com.loteca.orangetalents.novaaposta;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apostas")
public class NovaApostaController {

    @Autowired
    ApostadorRepository apostadorRepository;

    @Autowired
    ApostaService apostaService;
    
    @PostMapping
    @Transactional
    public NovaApostaResponse novaAposta(@Valid @RequestBody NovaApostaRequest request){

        Apostador apostador = request.toModel(apostadorRepository);
        Aposta aposta = apostaService.salvarNovaAposta(apostador);
        
        return new NovaApostaResponse(aposta);
    }
}
