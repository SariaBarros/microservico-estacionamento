package com.ada.gerenciamento;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/estacionamento/gerenciamento")
@RequiredArgsConstructor
public class GerenciamentoController {
    private final GerenciamentoService gerenciamentoService;
    @PostMapping("gerar")
    @ResponseStatus(HttpStatus.CREATED)
    public void gerarTicket(@RequestBody Gerenciamento gerenciamento){
        gerenciamentoService.gerarTicket(gerenciamento);

    }
    @GetMapping("{id}")
    public GerenciamentoResponse validarTicket(@PathVariable Long id){
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um ID!");
        }
        return gerenciamentoService.validarTicket(id);
    }
}
