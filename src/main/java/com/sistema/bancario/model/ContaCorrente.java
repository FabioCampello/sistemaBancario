package com.sistema.bancario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "CC")
public class ContaCorrente extends Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "limite_especial")
	private Double limite_especial;

	@NotNull
	@Column(name = "taxa_servicos")
	private Double taxa_servicos;

	public Double getLimite_especial() {
		return limite_especial;
	}

	public void setLimite_especial(Double limite_especial) {
		this.limite_especial = limite_especial;
	}

	public Double getTaxa_servicos() {
		return taxa_servicos;
	}

	public void setTaxa_servicos(Double taxa_servicos) {
		this.taxa_servicos = taxa_servicos;
	}

	public ContaCorrente(Long id, @NotNull String numero, Double saldo, @NotNull Agencia agencia,
			@NotNull Pessoa pessoa, Double limite_especial, @NotNull Double taxa_servicos) {
		super(id, numero, saldo, agencia, pessoa);
		this.limite_especial = limite_especial;
		this.taxa_servicos = taxa_servicos;
	}

}
