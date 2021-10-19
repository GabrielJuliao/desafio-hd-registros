package com.gabrieljuliao.desafiohdregistros.services;

import com.gabrieljuliao.desafiohdregistros.model.User;
import com.gabrieljuliao.desafiohdregistros.repository.ContaRepository;
import com.gabrieljuliao.desafiohdregistros.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final UserRepository userRepository;

    public ContaService(ContaRepository contaRepository, UserRepository userRepository) {
        this.contaRepository = contaRepository;
        this.userRepository = userRepository;
    }

    public BigDecimal consultarSaldo(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        return user.getConta().getSaldo();
    }
}
