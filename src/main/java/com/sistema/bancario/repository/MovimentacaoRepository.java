package com.sistema.bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.bancario.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
