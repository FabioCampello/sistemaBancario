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

import com.sistema.bancario.model.ContaCorrente;
import com.sistema.bancario.service.ContaCorrenteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/cc")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService contaCorrenteService;

	@RequestMapping(value = "updateSaveContaCorrente", method = RequestMethod.PUT)
	public ResponseEntity<ContaCorrente> updateSaveContaCorrente(@RequestBody ContaCorrente contaCorrente) {
		ResponseEntity<ContaCorrente> cc = null;
		try {
			cc = new ResponseEntity<ContaCorrente>(contaCorrenteService.updateSaveContaCorrente(contaCorrente),
					HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return cc;
	}

	@RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<ContaCorrente> findById(@PathVariable("id") Long id) {
		ResponseEntity<ContaCorrente> cc = null;
		try {
			cc = new ResponseEntity<ContaCorrente>(contaCorrenteService.findById(id), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return cc;
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ResponseEntity<List<ContaCorrente>> findAll() {
		ResponseEntity<List<ContaCorrente>> list = null;
		try {
			list = new ResponseEntity<List<ContaCorrente>>(contaCorrenteService.findAll(), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id) {
		try {
			contaCorrenteService.deleteById(id);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

}
