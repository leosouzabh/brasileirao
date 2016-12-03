package br.com.montreal.script.manager.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Processamento {
	
	public enum Status {
		AGENDADO("Agendado"),
		INICIADO("Iniciado"),
		FINALIZADO("Confirmar Pagamento");
				
		private String nome;

		private Status(String nome) {
			this.nome = nome;
		}
		
		public String getNome() {
			return nome;
		}
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Date dataInicio;
	
	@Column(nullable = true)
	private Long tempoGasto;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;
	
	@Column(nullable = true)
	private Boolean processadoComSucesso;
	
	@OneToMany(mappedBy = "processamento", cascade = CascadeType.ALL)
    private Set<EntradaProcessamento> entradasProcessamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Long getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(Long tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Boolean getProcessadoComSucesso() {
		return processadoComSucesso;
	}

	public void setProcessadoComSucesso(Boolean processadoComSucesso) {
		this.processadoComSucesso = processadoComSucesso;
	}

	public Set<EntradaProcessamento> getEntradasProcessamento() {
		return entradasProcessamento;
	}

	public void setEntradasProcessamento(Set<EntradaProcessamento> entradasProcessamento) {
		this.entradasProcessamento = entradasProcessamento;
	}
}
