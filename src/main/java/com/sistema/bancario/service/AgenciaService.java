package com.sistema.bancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bancario.model.Agencia;
import com.sistema.bancario.repository.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	private AgenciaRepository agenciaRepository;

	public Agencia updateSaveAgencia(Agencia agencia) {
		return agenciaRepository.save(agencia);
	}

	public Agencia findById(Long id) {
		return agenciaRepository.findById(id).get();
	}

	public List<Agencia> findAll() {
		return agenciaRepository.findAll();
	}

	public void deleteById(Long id) {
		agenciaRepository.deleteById(id);
	}

	public Agencia findByCodigo(String codigo) {
		Agencia agencia = null;
		try {
			agencia = agenciaRepository.findByCodigo(codigo);
		} catch (NullPointerException err) {
			err.printStackTrace();
		}
		return agencia;
	}

}
