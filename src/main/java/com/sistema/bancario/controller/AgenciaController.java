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

import com.sistema.bancario.model.Agencia;
import com.sistema.bancario.service.AgenciaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/agencia")
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;

	@RequestMapping(value = "updateSaveAgencia", method = RequestMethod.PUT)
	public ResponseEntity<Agencia> updateSaveAgencia(@RequestBody Agencia agencia) {
		ResponseEntity<Agencia> ag = null;
		try {
			ag = new ResponseEntity<Agencia>(agenciaService.updateSaveAgencia(agencia), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return ag;
	}

	@RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agencia> findById(@PathVariable("id") Long id) {
		ResponseEntity<Agencia> ag = null;
		try {
			ag = new ResponseEntity<Agencia>(agenciaService.findById(id), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return ag;
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Agencia>> findAll() {
		ResponseEntity<List<Agencia>> list = null;
		try {
			list = new ResponseEntity<List<Agencia>>(agenciaService.findAll(), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id) {
		try {
			agenciaService.deleteById(id);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	@RequestMapping(value = "findByCodigo/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Agencia> findByCodigo(@PathVariable("codigo") String codigo) {
		ResponseEntity<Agencia> ag = null;
		try {
			ag = new ResponseEntity<Agencia>(agenciaService.findByCodigo(codigo), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return ag;
	}

}
