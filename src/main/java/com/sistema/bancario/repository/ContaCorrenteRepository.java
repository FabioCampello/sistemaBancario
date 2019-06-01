package com.sistema.bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.bancario.model.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

	public ContaCorrente findByNumero(String num);

	public ContaCorrente findFirstByOrderById();
	
	public ContaCorrente findFirstByOrderByIdDesc();

}
