package br.com.montreal.script.runner;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import br.com.montreal.script.runner.groovy.GroovyRunner;
import br.com.montreal.script.runner.js.JavascriptRunner;

public class ScriptRunnerTest {
	
	private List<ScriptParameter> parameters;
	private ScriptRunner runner;
	
	@Before
	public void setup() throws IOException {
		String dataset1 = FileUtils.readFileToString(new File("src/test/resources/dataset1.json"), Charset.defaultCharset());
		String dataset2 = FileUtils.readFileToString(new File("src/test/resources/dataset2.json"), Charset.defaultCharset());
		
		parameters = new ArrayList<ScriptParameter>();
		parameters.add(new ScriptParameter("dataset1", dataset1));
		parameters.add(new ScriptParameter("dataset2", dataset2));
	}
	
	@Test
	public void testaJS() throws ScriptRunnerException, IOException {
		//given
		runner = new JavascriptRunner();
		String script = FileUtils.readFileToString(new File("src/test/resources/js/func.js"), Charset.defaultCharset());

		//when
		Map<String, Object> resultado = runner.run(script, parameters);

		//then
		assertThat(resultado.get("resultado")).isEqualTo("Jose");
	}

	@Test
	public void testaGroovy() throws ScriptRunnerException, IOException {
		//given
		runner = new GroovyRunner();
		String script = FileUtils.readFileToString(new File("src/test/resources/groovy/func.groovy"), Charset.defaultCharset());
		
		//when
		Map<String, Object> resultado = runner.run(script, parameters);

		//then
		assertThat(resultado.get("resultado")).isEqualTo("Jose");
	}
}
