package com.sistema.bancario.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sistema.bancario.model.Agencia;
import com.sistema.bancario.model.Endereco;
import com.sistema.bancario.service.AgenciaService;
import com.sistema.bancario.service.EnderecoService;

@Component
@Order(1)
public class CadastroAgencia implements CommandLineRunner {

	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private EnderecoService enderecoService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("**** Order 1 - CADASTRO DE AGÊNCIA *****");
		criarAgencia();
	}

	@SuppressWarnings("null")
	private Agencia criarAgencia() {
		System.out.println("*** Tentando criar agência bancária! ***");
		Agencia agencia = new Agencia(null, "Nubank", "85239", null);
		Endereco endereco = null;
		
		Agencia agenciaBase = null;
		try {
			agenciaBase = agenciaService.findByCodigo(agencia.getCodigo());
		} catch(NullPointerException err) {
			err.printStackTrace();
		}
		if(agenciaBase != null) {
			enderecoService.findByAgenciaId(agenciaBase.getId());
			System.out.println("*** Já existe um Agência bancária cadastrada com este código! ***");
			return agenciaBase;
		}
		agencia = agenciaService.updateSaveAgencia(agencia);
		endereco = new Endereco(null, "Rua Barão do Rio Branco", "1105", "Centro", "Fortaleza", agencia, null);
		enderecoService.updateSaveEndereco(endereco);
		System.out.println("*** Endereço salvo com sucesso! ***");
		System.out.println("*** Agência bancária cadastrada com sucesso! ***");
		return agencia;

	}

}
