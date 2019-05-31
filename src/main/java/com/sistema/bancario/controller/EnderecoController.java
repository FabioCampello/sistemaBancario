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

import com.sistema.bancario.model.Endereco;
import com.sistema.bancario.service.EnderecoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@RequestMapping(value = "updateSaveEndereco", method = RequestMethod.PUT)
	public ResponseEntity<Endereco> updateSaveEndereco(@RequestBody Endereco endereco) {
		ResponseEntity<Endereco> end = null;
		try {
			end = new ResponseEntity<Endereco>(enderecoService.updateSaveEndereco(endereco), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return end;
	}

	@RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> findById(@PathVariable("id") Long id) {
		ResponseEntity<Endereco> end = null;
		try {
			end = new ResponseEntity<Endereco>(enderecoService.findById(id), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return end;
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> findAll() {
		ResponseEntity<List<Endereco>> list = null;
		try {
			list = new ResponseEntity<List<Endereco>>(enderecoService.findAll(), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id) {
		try {
			enderecoService.deleteById(id);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
	
	@RequestMapping(value = "findByAgenciaId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> findByAgenciaId(@PathVariable("id") Long id) {
		ResponseEntity<Endereco> endereco = null;
		try {
			endereco = new ResponseEntity<Endereco>(enderecoService.findByAgenciaId(id), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return endereco;
	}

}
