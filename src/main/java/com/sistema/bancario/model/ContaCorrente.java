package com.sistema.bancario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contacorrente")
public class ContaCorrente extends Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "saldo")
	private Double saldo;

	@Column(name = "limite_especial")
	private Double limite_especial;

	@NotNull
	@Column(name = "taxa_servicos")
	private Double taxa_servicos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

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

	@Override
	public String toString() {
		return "ContaCorrente [id=" + id + ", saldo=" + saldo + ", limite_especial=" + limite_especial
				+ ", taxa_servicos=" + taxa_servicos + "]";
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
		ContaCorrente other = (ContaCorrente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
