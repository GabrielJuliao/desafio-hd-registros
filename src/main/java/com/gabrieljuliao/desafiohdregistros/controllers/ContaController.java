package com.gabrieljuliao.desafiohdregistros.controllers;

import com.gabrieljuliao.desafiohdregistros.services.ContaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
@RequestMapping(value = "/conta", produces = "application/json")
public class ContaController {
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping("/saldo")
    public BigDecimal getSaldo(Principal principal) {
        return contaService.consultarSaldo(principal);
    }
}
