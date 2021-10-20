package com.gabrieljuliao.desafiohdregistros.dto;

import com.gabrieljuliao.desafiohdregistros.model.Conta;
import com.gabrieljuliao.desafiohdregistros.model.Transacao;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
public class ExtratoDTO {
    private Double saldo;
    private Set<Transacao> transacao = new HashSet<>();

    public ExtratoDTO(Conta conta){
        this.saldo = conta.getSaldo();
        this.transacao.addAll(conta.getTransacao());
    }

}
