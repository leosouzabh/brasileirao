package br.com.brasileirao.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasileirao.model.Rodada;
import br.com.brasileirao.model.RodadaOut;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rodada")
public class RodadaController extends BaseApiController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<RodadaOut> get() {
		
		List<Rodada> lista = new ArrayList<Rodada>();
		
		lista.add( new Rodada(1, "Cruzeiro", "Palmeiras", new Date(), "São Januario" ) );
		lista.add( new Rodada(1, "Flamengo", "Palmeiras", new Date(), "São Januario" ) );
		lista.add( new Rodada(1, "Flamengo", "Atleticomg", new Date(), "São Januario" ) );
		lista.add( new Rodada(1, "Flamengo", "Palmeiras", new Date(), "São Januario" ) );
		lista.add( new Rodada(2, "Palmeiras", "Cruzeiro", new Date(), "São Januario" ) );
		lista.add( new Rodada(2, "Flamengo", "Palmeiras", new Date(), "São Januario" ) );
		lista.add( new Rodada(2, "Atleticomg", "Flamengo", new Date(), "São Januario" ) );
		lista.add( new Rodada(2, "Flamengo", "Palmeiras", new Date(), "São Januario" ) );
		
		
		return new ResponseEntity<RodadaOut>(new RodadaOut(lista, 2), HttpStatus.OK);
		
		
	}
	
	

}

