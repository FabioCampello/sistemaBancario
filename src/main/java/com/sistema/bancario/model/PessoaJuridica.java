package com.sistema.bancario.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("J")
public class PessoaJuridica extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 14, max = 14)
	@Column(name = "cnpj", unique = true)
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(Long id, @NotNull String nome, @NotNull String fone, Calendar dataNascimento,
			Endereco endereco) {
		super(id, nome, fone, dataNascimento, endereco);
		// TODO Auto-generated constructor stub
	}

	public PessoaJuridica(Long id, @NotNull String nome, @NotNull String fone, Calendar dataNascimento,
			Endereco endereco, @NotNull @Size(min = 14, max = 14) String cnpj) {
		super(id, nome, fone, dataNascimento, endereco);
		this.cnpj = cnpj;
	}

}
