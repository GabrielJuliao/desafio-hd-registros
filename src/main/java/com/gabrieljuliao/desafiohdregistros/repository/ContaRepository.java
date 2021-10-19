package com.gabrieljuliao.desafiohdregistros.repository;

import com.gabrieljuliao.desafiohdregistros.model.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Long> {
}
