package com.sistema.bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.bancario.model.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

}
