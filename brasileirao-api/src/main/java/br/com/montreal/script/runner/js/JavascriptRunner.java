package br.com.montreal.script.runner.js;


import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import br.com.montreal.script.runner.ScriptParameter;
import br.com.montreal.script.runner.ScriptRunner;
import br.com.montreal.script.runner.ScriptRunnerException;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

@SuppressWarnings("restriction")
public class JavascriptRunner implements ScriptRunner {

	private static final ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript"); //TODO ver que que da pra fazer com esse new
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> run(String script, List<ScriptParameter> variables) throws ScriptRunnerException {
		try {
			variables.forEach( v -> {
				engine.put(v.getNome(), v.getValor());
			});
			
			engine.eval(script);
	
			ScriptObjectMirror o = (ScriptObjectMirror) engine.get("resultado");
			
			return o.to(Map.class);
			
		} catch (ScriptException e) {
			throw new ScriptRunnerException(e);
		}
	}
}
