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

import com.sistema.bancario.model.Movimentacao;
import com.sistema.bancario.service.MovimentacaoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/movimentacao")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService movimentacaoService;

	@RequestMapping(value = "updateSaveMovimentacao", method = RequestMethod.PUT)
	public ResponseEntity<Movimentacao> updateSaveMovimentacao(@RequestBody Movimentacao movimentacao) {
		ResponseEntity<Movimentacao> mov = null;
		try {
			mov = new ResponseEntity<Movimentacao>(movimentacaoService.updateSaveMovimentacao(movimentacao),
					HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return mov;
	}

	@RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Movimentacao> findById(@PathVariable("id") Long id) {
		ResponseEntity<Movimentacao> mov = null;
		try {
			mov = new ResponseEntity<Movimentacao>(movimentacaoService.findById(id), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return mov;
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Movimentacao>> findAll() {
		ResponseEntity<List<Movimentacao>> list = null;
		try {
			list = new ResponseEntity<List<Movimentacao>>(movimentacaoService.findAll(), HttpStatus.OK);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id) {
		try {
			movimentacaoService.deleteById(id);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

}
