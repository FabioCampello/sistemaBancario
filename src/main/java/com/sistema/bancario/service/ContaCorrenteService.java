package com.sistema.bancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bancario.model.ContaCorrente;
import com.sistema.bancario.repository.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	public ContaCorrente updateSaveContaCorrente(ContaCorrente contaCorrente) {
		return contaCorrenteRepository.save(contaCorrente);
	}

	public ContaCorrente findById(Long id) {
		return contaCorrenteRepository.findById(id).get();
	}

	public List<ContaCorrente> findAll() {
		return contaCorrenteRepository.findAll();
	}

	public void deleteById(Long id) {
		contaCorrenteRepository.deleteById(id);
	}

}
