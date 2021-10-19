package com.gabrieljuliao.desafiohdregistros.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal saldo;
    @OneToOne(mappedBy = "conta")
    private User user;

    public Conta(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
