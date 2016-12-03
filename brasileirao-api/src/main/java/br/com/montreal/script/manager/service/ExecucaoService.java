package br.com.montreal.script.manager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.montreal.script.manager.controller.api.resource.InputProcessamento;
import br.com.montreal.script.runner.ScriptParameter;
import br.com.montreal.script.runner.ScriptRunner;
import br.com.montreal.script.runner.ScriptRunnerException;
import br.com.montreal.script.runner.js.JavascriptRunner;

@Service
public class ExecucaoService {
	
	public Map<String, Object> processa(InputProcessamento regraCruzamento) throws ScriptRunnerException {

		ScriptRunner runner = new JavascriptRunner();
		List<ScriptParameter> parameters = new ArrayList<ScriptParameter>();

		regraCruzamento.getDatasets().forEach(dataset -> { 
			parameters.add( new ScriptParameter(dataset.getNome(), dataset.getDataset()) );
		});

		return runner.run(regraCruzamento.getScript(), parameters);
	}

}

