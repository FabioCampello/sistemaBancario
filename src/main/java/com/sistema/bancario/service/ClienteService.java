package com.sistema.bancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bancario.model.Cliente;
import com.sistema.bancario.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente updateSaveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente findById(Long id) {
		return clienteRepository.findById(id).get();
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}

}
