package com.gabrieljuliao.desafiohdregistros.dto;

import com.gabrieljuliao.desafiohdregistros.model.Transacao;
import lombok.Data;

import java.util.Date;

@Data
public class TransacaoDTO {
    private Date data;
    private Double valor;

    public TransacaoDTO(Transacao transacao){
        this.data = transacao.getData();
        this.valor = transacao.getValor();
    }

}
