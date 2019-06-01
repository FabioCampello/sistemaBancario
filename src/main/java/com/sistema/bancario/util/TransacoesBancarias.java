package com.sistema.bancario.util;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sistema.bancario.model.ContaCorrente;
import com.sistema.bancario.model.Movimentacao;
import com.sistema.bancario.model.TipoMovimentacao;
import com.sistema.bancario.service.ContaCorrenteService;
import com.sistema.bancario.service.MovimentacaoService;

@Component
@Order(4)
public class TransacoesBancarias implements CommandLineRunner {

	@Autowired
	private ContaCorrenteService contaCorrenteService;
	
	@Autowired
	private MovimentacaoService movimentacaoService;

	@Override public void run(String... args) throws Exception {
		System.out.println("**** Order 3 - TRANSAÇÕES BANCÁRIAS *****");
		deposito();
		saque();
		transferecia();
	}

	private void deposito() {
		System.out.println("*** Realizando depósito em conta! ***");
		Double valor = 150.0;
		ContaCorrente conta1 = contaCorrenteService.findFirstByOrderById();
		conta1.setSaldo(conta1.getSaldo() + valor); 
		contaCorrenteService.updateSaveContaCorrente(conta1);
		movimentarConta(conta1, null, TipoMovimentacao.DEPOSITO, valor);
		System.out.println("*** Depósito realizado com sucesso! ***");
	}
	
	private void saque() {
		System.out.println("*** Realizando saque em conta! ***");
		Double valor = 25.0;
		ContaCorrente conta2 = contaCorrenteService.findFirstByOrderById();
		if(conta2.getSaldo() >= valor) {
			Double saldo = conta2.getSaldo();
			conta2.setSaldo(saldo -= valor);
			contaCorrenteService.updateSaveContaCorrente(conta2);
			movimentarConta(conta2, null, TipoMovimentacao.SAQUE, valor);
			System.out.println("*** Saque efetuado com sucesso! ***");
		} else {
			System.out.println("*** Saldo insuficiente! ***");
		}
	}
	
	private void transferecia() {
		System.out.println("*** Realizando transferecia em conta! ***");
		Double valor = 55.0;
		ContaCorrente contaOrigem = contaCorrenteService.findFirstByOrderById();
		ContaCorrente contaDestino = contaCorrenteService.findFirstByOrderByIdDesc();
		if(contaOrigem.getSaldo() >= valor) {
			Double saldo = contaOrigem.getSaldo();
			contaOrigem.setSaldo(saldo -= valor);
			contaCorrenteService.updateSaveContaCorrente(contaOrigem);
			movimentarConta(contaOrigem, contaDestino, TipoMovimentacao.TRANSFERENCIA, valor);
			Double saldoContaDestino = contaDestino.getSaldo();
			contaDestino.setSaldo(saldoContaDestino += valor);
			contaCorrenteService.updateSaveContaCorrente(contaDestino);
			movimentarConta(contaOrigem, contaDestino, TipoMovimentacao.DEPOSITO, valor);
			
		} else {
			System.out.println("*** Saldo insuficiente! ***");
		}
	}
	
	private void movimentarConta(ContaCorrente contaOrigem, ContaCorrente contaDestino, TipoMovimentacao tipo, Double valor) {
		Movimentacao movimentacao = new Movimentacao();
		Calendar hoje = Calendar.getInstance();
		movimentacao.setData(hoje);
		movimentacao.setTipoMovimentacao(tipo);
		movimentacao.setValor(valor);
		movimentacao.setContaOrigem(contaOrigem);
		movimentacao.setContaDestino(contaDestino);
		System.out.println("*** Guardando movimentação da conta! ***");
		movimentacaoService.updateSaveMovimentacao(movimentacao);
	}

}
