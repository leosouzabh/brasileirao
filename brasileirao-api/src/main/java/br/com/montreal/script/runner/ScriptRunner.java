package br.com.montreal.script.runner;

import java.util.List;
import java.util.Map;

public interface ScriptRunner {

	Map<String, Object> run(String script, List<ScriptParameter> variables) throws ScriptRunnerException;

}
