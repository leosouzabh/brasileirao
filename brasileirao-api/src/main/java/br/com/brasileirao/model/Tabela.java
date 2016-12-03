package br.com.brasileirao.model;

public class Tabela {
	
	private String chave;
	private String nome;
	private Integer pontos;
	private Integer vitorias;
	private Integer empates;
	private Integer derrotas;
	private Integer saldoGols;
	private Integer numJogos;
	
	public Tabela() {
		super();
	}
	public Tabela(String nome, Integer pontos, Integer vitorias, Integer empates, Integer derrotas, Integer saldoGols,
			Integer numJogos) {
		super();
		this.nome = nome;
		this.pontos = pontos;
		this.vitorias = vitorias;
		this.empates = empates;
		this.derrotas = derrotas;
		this.saldoGols = saldoGols;
		this.numJogos = numJogos;
	}

	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	public Integer getVitorias() {
		return vitorias;
	}
	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}
	public Integer getEmpates() {
		return empates;
	}
	public void setEmpates(Integer empates) {
		this.empates = empates;
	}
	public Integer getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}
	public Integer getSaldoGols() {
		return saldoGols;
	}
	public void setSaldoGols(Integer saldoGols) {
		this.saldoGols = saldoGols;
	}
	public Integer getNumJogos() {
		return numJogos;
	}
	public void setNumJogos(Integer numJogos) {
		this.numJogos = numJogos;
	}
	
	
	
}
