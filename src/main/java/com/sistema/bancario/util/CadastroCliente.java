package com.sistema.bancario.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sistema.bancario.model.Agencia;
import com.sistema.bancario.model.Conta;
import com.sistema.bancario.model.ContaCorrente;
import com.sistema.bancario.model.Endereco;
import com.sistema.bancario.model.Pessoa;
import com.sistema.bancario.model.PessoaFisica;
import com.sistema.bancario.service.ClienteService;
import com.sistema.bancario.service.ContaCorrenteService;
import com.sistema.bancario.service.EnderecoService;

@Component
@Order(2)
public class CadastroCliente implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private ContaCorrenteService contaCorrenteService;
	
	@Override
	public void run(String... args) {
		System.out.println("**** Order 2 - CADASTRO CLIENTES *****");
		cadastrarPessoa();
	}

	private void cadastrarPessoa() {
		System.out.println("*** Cadastrando a primeira conta! ***");
		Pessoa pes1 = new PessoaFisica(null, "João", "987228951", null, null, "12345678952");
		Endereco end1 = null;
		Agencia agencia1 = new Agencia((long) 1, "26089", "Inter");
		Conta contaCorrente1 = new ContaCorrente(null, "10052478", 0.0, agencia1, pes1, 500.0, 7.5);
		try {
			pes1 = clienteService.updateSaveCliente(pes1);
			end1 = new Endereco(null, "Rua Lonardo Mota", "15", "Aldeota", "Fortaleza", null, pes1);
			enderecoService.updateSaveEndereco(end1);
			contaCorrenteService.updateSaveContaCorrente((ContaCorrente) contaCorrente1);
		} catch(Exception err) {
			System.out.println("*** Cliente já cadastrado! ***");
		}
		
		System.out.println("*** Cadastrando a segunda conta! ***");
		Pessoa pes2 = new PessoaFisica(null, "Pedro", "963254471", null, null, "92435874496");
		Endereco end2 = null;
		Agencia agencia2 = new Agencia((long) 1, "24229", "Inter");
		Conta contaCorrente2 = new ContaCorrente(null, "00054257", 0.0, agencia2, pes2, 100.0, 7.5);
		try {
			pes2 = clienteService.updateSaveCliente(pes2);
			end2 = new Endereco(null, "Av. Leste Oeste", "722", "Barra do Ceará", "Fortaleza", null, pes2);
			enderecoService.updateSaveEndereco(end2);
			contaCorrenteService.updateSaveContaCorrente((ContaCorrente) contaCorrente2);
		} catch(Exception err) {
			System.out.println("*** Cliente já cadastrado! ***");
		}
		
	}

}
