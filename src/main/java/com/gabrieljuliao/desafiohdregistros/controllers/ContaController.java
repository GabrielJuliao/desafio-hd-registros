package com.gabrieljuliao.desafiohdregistros.controllers;

import com.gabrieljuliao.desafiohdregistros.dto.ExtratoDTO;
import com.gabrieljuliao.desafiohdregistros.dto.SaldoDTO;
import com.gabrieljuliao.desafiohdregistros.dto.TransacaoDTO;
import com.gabrieljuliao.desafiohdregistros.services.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/conta", produces = "application/json")
public class ContaController {
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping("/saldo")
    public ResponseEntity<SaldoDTO> getSaldo(Principal principal) {
        return new ResponseEntity<>(contaService.consultarSaldo(principal), HttpStatus.OK);
    }

    @PostMapping("/transferir/{valor}/{destino}")
    public ResponseEntity<TransacaoDTO> transferir(@PathVariable("valor") Double valor, @PathVariable("destino") Long id, Principal principal) {
        return new ResponseEntity<>(contaService.transferir(principal, valor, id), HttpStatus.OK);
    }

    @GetMapping("/extrato")
    public ResponseEntity<ExtratoDTO> getExtrato(Principal principal) {
        return new ResponseEntity<>(contaService.tirarExtrato(principal), HttpStatus.OK);
    }
}
