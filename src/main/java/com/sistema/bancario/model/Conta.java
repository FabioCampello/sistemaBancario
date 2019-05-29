package com.sistema.bancario.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Conta {

	@NotNull
	@Column(name = "numero", unique = true)
	private String numero;

	@Column(name = "saldo")
	private Double saldo;

	@OneToMany
	@JoinColumn(name = "conta_id")
	private List<Movimentacao> movimentacao;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Movimentacao> getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", movimentacao=" + movimentacao + "]";
	}

}
