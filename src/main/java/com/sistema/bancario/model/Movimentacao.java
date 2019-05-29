package com.sistema.bancario.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "movimentacao")
public class Movimentacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Calendar data;

	@Column(name = "tipo_movimentacao")
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	@NotNull
	@Column(name = "valor")
	private Double valor;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "conta_origem_id", foreignKey = @ForeignKey(name = "FK_conta_origem"))
	private Conta contaOrigem;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "conta_destino_id", foreignKey = @ForeignKey(name = "FK_conta_destino"))
	private Conta contaDestino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	public Movimentacao(Long id, Calendar data, TipoMovimentacao tipoMovimentacao, @NotNull Double valor,
			@NotNull Conta contaOrigem) {
		super();
		this.id = id;
		this.data = data;
		this.tipoMovimentacao = tipoMovimentacao;
		this.valor = valor;
		this.contaOrigem = contaOrigem;
	}

	public Movimentacao(Long id, Calendar data, TipoMovimentacao tipoMovimentacao, @NotNull Double valor,
			@NotNull Conta contaOrigem, @NotNull Conta contaDestino) {
		super();
		this.id = id;
		this.data = data;
		this.tipoMovimentacao = tipoMovimentacao;
		this.valor = valor;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
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
		Movimentacao other = (Movimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
