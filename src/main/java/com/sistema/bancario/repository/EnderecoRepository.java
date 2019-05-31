package com.sistema.bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.bancario.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	Endereco findByAgenciaId(Long agenciaId);

}
