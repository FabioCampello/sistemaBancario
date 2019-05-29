package com.sistema.bancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bancario.model.Movimentacao;
import com.sistema.bancario.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	public Movimentacao updateSaveMovimentacao(Movimentacao movimentacao) {
		return movimentacaoRepository.save(movimentacao);
	}

	public Movimentacao findById(Long id) {
		return movimentacaoRepository.findById(id).get();
	}

	public List<Movimentacao> findAll() {
		return movimentacaoRepository.findAll();
	}

	public void deleteById(Long id) {
		movimentacaoRepository.deleteById(id);
	}

}
