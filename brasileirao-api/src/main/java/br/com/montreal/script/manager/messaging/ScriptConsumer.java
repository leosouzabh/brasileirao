package br.com.montreal.script.manager.messaging;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.montreal.script.manager.controller.api.resource.InputProcessamento;
import br.com.montreal.script.manager.service.ExecucaoService;
import br.com.montreal.script.manager.service.ProcessamentoService;
import br.com.montreal.script.runner.ScriptRunnerException;

@Component
public class ScriptConsumer {
	
	private final ExecucaoService execucaoService;
	private final ProcessamentoService processamentoService;
	private static final Logger log = LoggerFactory.getLogger(ScriptConsumer.class);
	
	public ScriptConsumer(ExecucaoService execucaoService, ProcessamentoService processamentoService) {
		this.execucaoService = execucaoService;
		this.processamentoService = processamentoService;
	}

	@JmsListener(destination = "scriptRunnerQueue")
    public void receiveMessage(InputProcessamento input) {
		log.info("Iniciando processamento: " + input.getDescricao());
		
		processamentoService.atualizaStatusInicializado(input.getId());		
		log.info("Processamento " + input.getDescricao() + " INICIADO");
		
		try {
			//try { Thread.sleep(5000); } catch (InterruptedException e) {}
			Map<String, Object> mapaResultado = execucaoService.processa(input);
			processamentoService.gravaResultado(input.getId(),  mapaResultado.toString());
			
		} catch (ScriptRunnerException e1) {
			processamentoService.gravaErro(input.getId(), e1.getMessage());
			log.info("Processamento " + input.getDescricao() + " FINALIZADO");
		}
		
		
    }

	
    
}
