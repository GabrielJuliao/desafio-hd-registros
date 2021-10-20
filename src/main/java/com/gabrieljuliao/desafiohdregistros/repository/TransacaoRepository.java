package com.gabrieljuliao.desafiohdregistros.repository;

import com.gabrieljuliao.desafiohdregistros.model.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
}
