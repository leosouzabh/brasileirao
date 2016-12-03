package br.com.montreal.script.runner;

public class ScriptParameter {
	
	private final String nome;
	private final Object valor;
	
	public ScriptParameter(String nome, Object valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}
	
	public Object getValor() {
		return valor;
	}

}
