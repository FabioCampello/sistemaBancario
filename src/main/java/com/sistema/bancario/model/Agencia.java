package com.sistema.bancario.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "agencia")
public class Agencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Size(min = 5, max = 5)
	@Column(name = "codigo", unique = true)
	private String codigo;

	@OneToOne(mappedBy = "agencia", cascade = CascadeType.ALL)
	private Endereco endereco;

	@OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL)
	private List<Conta> conta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Conta> getConta() {
		return conta;
	}

	public void setConta(List<Conta> conta) {
		this.conta = conta;
	}

	public Agencia() {
		super();
	}

	public Agencia(Long id, @NotNull String nome, @NotNull @Size(min = 5, max = 5) String codigo) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
	}

	public Agencia(Long id, @NotNull String nome, @NotNull @Size(min = 5, max = 5) String codigo, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Agencia [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", endereco=" + endereco + ", conta="
				+ conta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
