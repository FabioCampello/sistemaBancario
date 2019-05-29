package com.sistema.bancario.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public abstract class Pessoa {

	@NotNull
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "fone")
	private String fone;

	@Size(min = 11, max = 11)
	@Column(name = "cpf", unique = true)
	private String cpf;

	@Column(name = "data_nascimento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Calendar dataNascimento;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

}
