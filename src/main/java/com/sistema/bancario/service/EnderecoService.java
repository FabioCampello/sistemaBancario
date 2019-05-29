package com.sistema.bancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bancario.model.Endereco;
import com.sistema.bancario.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco updateSaveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco findById(Long id) {
		return enderecoRepository.findById(id).get();
	}

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public void deleteById(Long id) {
		enderecoRepository.deleteById(id);
	}

}
