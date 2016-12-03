package br.com.montreal.script.manager.model;

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

@Entity
public class EntradaProcessamento {
	
	public enum Tipo { DATASET, SCRIPT, ERRO, RESULTADO }
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = true, length = 5000)
	private String entrada;
	
	@Column(nullable = true)
	private String chave;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private Tipo tipo;
	
	@ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "FK_PROCESSAMENTO_ENTRADA"), name="ID_ENTRADA")
    private Processamento processamento;

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Processamento getProcessamento() {
		return processamento;
	}

	public void setProcessamento(Processamento processamento) {
		this.processamento = processamento;
	}
	
}
