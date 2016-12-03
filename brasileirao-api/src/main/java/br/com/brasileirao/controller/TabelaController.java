package br.com.brasileirao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasileirao.model.Tabela;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tabela")
public class TabelaController extends BaseApiController {
	
	//private final ProcessamentoService processamentoService;

	/*public ProcessaController(ProcessamentoService processamentoService) {
		this.processamentoService = processamentoService;
	}*/

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Tabela>> get() {
		
		List<Tabela> lista = new ArrayList<Tabela>();
		lista.add(new Tabela("Palmeiras", 77, 23, 8, 6, 29, 37));
		lista.add(new Tabela("Flamengo", 70, 20, 10, 7, 17, 37));
		lista.add(new Tabela("Santos", 68, 21, 5, 11, 23, 37));
		lista.add(new Tabela("Atlético MG", 62, 17, 11, 9, 11, 37));
		lista.add(new Tabela("Atlético PR", 56, 17, 5, 15, 6, 37));
		lista.add(new Tabela("Palmeiras", 77, 23, 8, 6, 29, 37));
		lista.add(new Tabela("Flamengo", 70, 20, 10, 7, 17, 37));
		lista.add(new Tabela("Santos", 68, 21, 5, 11, 23, 37));
		lista.add(new Tabela("Atlético MG", 62, 17, 11, 9, 11, 37));
		lista.add(new Tabela("Atlético PR", 56, 17, 5, 15, 6, 37));
		lista.add(new Tabela("Palmeiras", 77, 23, 8, 6, 29, 37));
		lista.add(new Tabela("Flamengo", 70, 20, 10, 7, 17, 37));
		lista.add(new Tabela("Santos", 68, 21, 5, 11, 23, 37));
		lista.add(new Tabela("Atlético MG", 62, 17, 11, 9, 11, 37));
		lista.add(new Tabela("Chapecoense AF", 56, 17, 5, 15, 6, 37));
		
		
		return new ResponseEntity<List<Tabela>>(lista, HttpStatus.OK);
		
		
	}
	
	

}

