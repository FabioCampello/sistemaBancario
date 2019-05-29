package com.sistema.bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.bancario.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
