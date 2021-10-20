package com.gabrieljuliao.desafiohdregistros.services;

import com.gabrieljuliao.desafiohdregistros.dto.ExtratoDTO;
import com.gabrieljuliao.desafiohdregistros.dto.SaldoDTO;
import com.gabrieljuliao.desafiohdregistros.dto.TransacaoDTO;
import com.gabrieljuliao.desafiohdregistros.model.Conta;
import com.gabrieljuliao.desafiohdregistros.model.Transacao;
import com.gabrieljuliao.desafiohdregistros.model.User;
import com.gabrieljuliao.desafiohdregistros.repository.ContaRepository;
import com.gabrieljuliao.desafiohdregistros.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final UserRepository userRepository;

    public ContaService(ContaRepository contaRepository, UserRepository userRepository) {
        this.contaRepository = contaRepository;
        this.userRepository = userRepository;
    }

    public SaldoDTO consultarSaldo(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        return new SaldoDTO(user.getConta().getSaldo(), new Date());
    }

    public ExtratoDTO tirarExtrato(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        return new ExtratoDTO(user.getConta());
    }

    public TransacaoDTO transferir(Principal principal, Double valor, Long destId) {
        User remetente = userRepository.findByUsername(principal.getName());

        if (remetente.getConta().getSaldo() >= valor) {
            Optional<Conta> optionalConta = contaRepository.findById(destId);
            if (optionalConta.isPresent()) {

                Conta conta = optionalConta.get();
                User destinatario = conta.getUser();

                Date data = new Date();

                Transacao remTransacao = new Transacao(-valor, data);

                remetente.getConta().getTransacao().add(remTransacao);
                destinatario.getConta().getTransacao().add(new Transacao(valor, data));

                remetente.getConta().setSaldo(remetente.getConta().getSaldo() - valor);
                destinatario.getConta().setSaldo(destinatario.getConta().getSaldo() + valor);

                userRepository.save(remetente);
                userRepository.save(destinatario);

                return new TransacaoDTO(remTransacao);
            }
        }
        return null;
    }
}
