package br.com.brasileirao.model;

public class TimeRodada {
	
	private String nome;
	private Integer gol;
	
	public TimeRodada(String nome, Integer gol) {
		super();
		this.nome = nome;
		this.gol = gol;
	}
	public TimeRodada(String timeA, int gol2) {
		this.nome = timeA;
		this.gol = gol2;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getGol() {
		return gol;
	}
	public void setGol(Integer gol) {
		this.gol = gol;
	}
	
	
		
}
