package com.sistema.bancario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.bancario.model.Pessoa;
import com.sistema.bancario.service.ClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "updateSaveCliente", method = RequestMethod.PUT)
	public ResponseEntity<Pessoa> updateSaveCliente(@RequestBody Pessoa cliente) {
		ResponseEntity<Pessoa> cli = null;
		try {
			cli = new ResponseEntity<Pessoa>(clienteService.updateSaveCliente(cliente), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return cli;
	}

	@RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> findById(@PathVariable("id") Long id) {
		ResponseEntity<Pessoa> cli = null;
		try {
			cli = new ResponseEntity<Pessoa>(clienteService.findById(id), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return cli;
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> findAll() {
		ResponseEntity<List<Pessoa>> list = null;
		try {
			list = new ResponseEntity<List<Pessoa>>(clienteService.findAll(), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id) {
		try {
			clienteService.deleteById(id);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

}
