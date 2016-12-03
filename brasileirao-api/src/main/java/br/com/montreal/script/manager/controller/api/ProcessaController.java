package br.com.montreal.script.manager.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.montreal.script.manager.controller.api.resource.InputProcessamento;
import br.com.montreal.script.manager.model.Processamento;
import br.com.montreal.script.manager.service.ProcessamentoService;

@RestController
@RequestMapping("/api/processa")
public class ProcessaController extends BaseApiController {
	
	private final ProcessamentoService processamentoService;

	public ProcessaController(ProcessamentoService processamentoService) {
		this.processamentoService = processamentoService;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> post(@RequestBody InputProcessamento input) {
		
		if ( StringUtils.isEmpty(input.getDescricao()) || CollectionUtils.isEmpty(input.getDatasets()) || StringUtils.isEmpty(input.getScript()) ){
			return errorHandle("Todos os campos (descrição, datasets, script) são obrigatórios", HttpStatus.BAD_REQUEST);	
		
		} else {
			Processamento processamento = processamentoService.salva(input);
			return new ResponseEntity<Object>(processamento.getId(), HttpStatus.OK);
		}
		
		
	}
	
	

}

