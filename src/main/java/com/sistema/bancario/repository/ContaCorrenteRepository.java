package com.sistema.bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.bancario.model.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

}
