package br.com.montreal.script.runner.groovy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.codehaus.groovy.control.CompilationFailedException;

import br.com.montreal.script.runner.ScriptParameter;
import br.com.montreal.script.runner.ScriptRunner;
import br.com.montreal.script.runner.ScriptRunnerException;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class GroovyRunner implements ScriptRunner {

	private static final GroovyShell shell = new GroovyShell(); //TODO ver que que da pra fazer com esse new
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> run(String script, List<ScriptParameter> variables) throws ScriptRunnerException {
		Map<String, Object> map = variables.stream().collect(Collectors.toMap(ScriptParameter::getNome, ScriptParameter::getValor));
		Binding binding = new Binding(map);

		try {
			Script s = shell.parse(script);
			s.setBinding(binding);

			return (Map<String, Object>) s.run();
		} catch (CompilationFailedException e) {
			throw new ScriptRunnerException(e);
		}
	}

}
