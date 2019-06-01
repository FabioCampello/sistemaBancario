package com.sistema.bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.bancario.model.Pessoa;

public interface ClienteRepository extends JpaRepository<Pessoa, Long> {

}
