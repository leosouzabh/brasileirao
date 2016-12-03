package br.com.brasileirao.model;

import java.util.List;

public class RodadaOut {
	
	private List<Rodada> rodadas;
	private Integer rodadaAtual;
	
	public RodadaOut(List<Rodada> rodadas, Integer rodadaAtual) {
		super();
		this.rodadas = rodadas;
		this.rodadaAtual = rodadaAtual;
	}
	public List<Rodada> getRodadas() {
		return rodadas;
	}
	public void setRodadas(List<Rodada> rodadas) {
		this.rodadas = rodadas;
	}
	public Integer getRodadaAtual() {
		return rodadaAtual;
	}
	public void setRodadaAtual(Integer rodadaAtual) {
		this.rodadaAtual = rodadaAtual;
	}
	
	
		
}
