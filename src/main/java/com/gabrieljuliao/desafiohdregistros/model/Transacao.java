package com.gabrieljuliao.desafiohdregistros.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private Double valor;

    public Transacao(Double valor, Date data) {
        this.valor = valor;
        this.data = data;
    }
}
