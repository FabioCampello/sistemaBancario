package com.sistema.bancario.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "cpf", unique = true)
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PessoaFisica(Long id, @NotNull String nome, @NotNull String fone, Calendar dataNascimento, Endereco endereco,
			@NotNull @Size(min = 11, max = 11) String cpf) {
		super(id, nome, fone, dataNascimento, endereco);
		this.cpf = cpf;
	}

}
