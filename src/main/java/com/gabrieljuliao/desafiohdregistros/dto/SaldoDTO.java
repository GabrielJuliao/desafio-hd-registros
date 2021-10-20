package com.gabrieljuliao.desafiohdregistros.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SaldoDTO {
    private double saldo;
    private Date data;

    public SaldoDTO(double saldo, Date data) {
        this.saldo = saldo;
        this.data = data;
    }
}
