package br.com.montreal.script.manager.controller.api.resource;

import java.util.List;

public class InputProcessamento {
	
	private String descricao;
	private List<InputDataset> datasets;
	private String script;
	private Long id;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<InputDataset> getDatasets() {
		return datasets;
	}
	public void setDatasets(List<InputDataset> datasets) {
		this.datasets = datasets;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
