package br.com.montreal.script.manager.controller.api;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.montreal.script.manager.controller.api.resource.InputDataset;
import br.com.montreal.script.manager.controller.api.resource.InputProcessamento;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ProcessaApiTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void chamadaComSucesso() throws Exception {
		
		//given
		String url = "/api/processa";
		InputProcessamento input = new InputProcessamento();
		
		input.setDescricao("Função de ocorrencia");
		input.setDatasets(new ArrayList<InputDataset>());
		input.getDatasets().add( new InputDataset("dataset1", readResource("dataset1.json")) );
		input.getDatasets().add( new InputDataset("dataset2", readResource("dataset2.json")) );
		input.setScript( readResource("js/func.js") );
		
		//when
		ResponseEntity<Object> entity = restTemplate.postForEntity(url, input, Object.class);
		Thread.sleep(5000);
		
		//then
		assertThat(entity.getBody()).isEqualTo(1);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void chamadaComInputInvalido() throws Exception {
		
		//given
		String url = "/api/processa";
		InputProcessamento input = new InputProcessamento();
		
		//when
		ResponseEntity<Object> entity = restTemplate.postForEntity(url, input, Object.class);
		Thread.sleep(5000);
		//then
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	private String readResource(String path) throws IOException{
		return FileUtils.readFileToString(new File("src/test/resources/"+path), Charset.defaultCharset());	
	}

}
