package com.gabrieljuliao.desafiohdregistros.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double saldo;
    @OneToOne(mappedBy = "conta")
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "conta_transacao")
    private Set<Transacao> transacao = new HashSet<>();

    public Conta(Double saldo) {
        this.saldo = saldo;
    }
}
