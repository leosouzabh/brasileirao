package br.com.montreal.script.manager.controller.api.resource;

public class InputDataset {
	
	private String nome;
	private String dataset;
	
	public InputDataset(){}
	public InputDataset(String nome, String dataset) {
		super();
		this.nome = nome;
		this.dataset = dataset;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataset() {
		return dataset;
	}
	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	
}
