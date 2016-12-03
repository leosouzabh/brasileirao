package br.com.montreal.script.manager.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.com.montreal.script.manager.controller.api.resource.InputDataset;
import br.com.montreal.script.manager.controller.api.resource.InputProcessamento;
import br.com.montreal.script.manager.model.EntradaProcessamento;
import br.com.montreal.script.manager.model.EntradaProcessamento.Tipo;
import br.com.montreal.script.manager.model.Processamento;
import br.com.montreal.script.manager.model.Processamento.Status;
import br.com.montreal.script.manager.repository.ProcessamentoRepository;

@Service
public class ProcessamentoService {
	
	private final ProcessamentoRepository processamentoRepository;
	private final JmsTemplate jmsTemplate;
	
	public ProcessamentoService(ProcessamentoRepository processamentoRepository, JmsTemplate jmsTemplate) {
		this.processamentoRepository = processamentoRepository;
		this.jmsTemplate = jmsTemplate;
	}
	
	public Processamento salva(InputProcessamento input) {
		
		Processamento processamento = doSave(input);
		enviaPacoteJms(input, processamento);
		return processamento;
	}
	
	private void enviaPacoteJms(InputProcessamento input, Processamento processamento){
		input.setId(processamento.getId());
		jmsTemplate.convertAndSend("scriptRunnerQueue", input);
	}

	private Processamento doSave(InputProcessamento input) {
		Processamento processamento = new Processamento();
		processamento.setDescricao(input.getDescricao());
		processamento.setDataInicio(new Date());
		processamento.setStatus(Status.AGENDADO);
		
		Set<EntradaProcessamento> entradas = new HashSet<EntradaProcessamento>();
		
		Iterator<InputDataset> it = input.getDatasets().iterator();
		while(it.hasNext()){
			
			InputDataset inputDs = it.next();
			
			EntradaProcessamento p = new EntradaProcessamento();
			p.setChave(inputDs.getNome());
			p.setEntrada(inputDs.getDataset());
			p.setProcessamento(processamento);
			p.setTipo(Tipo.DATASET);
			entradas.add(p);
		}
		EntradaProcessamento p = new EntradaProcessamento();
		p.setChave("script");
		p.setEntrada(input.getScript());
		p.setProcessamento(processamento);
		p.setTipo(Tipo.SCRIPT);
		entradas.add(p);
		
		processamento.setEntradasProcessamento(entradas);
		processamentoRepository.save(processamento);
		
		return processamento;
	}
	
	
	public Processamento atualizaStatusInicializado(Long idProcessamento) {
		return doAtualizaStatus(idProcessamento, Status.INICIADO, null);
	}

	private Processamento doAtualizaStatus(Long idProcessamento, Status status, Boolean processadoComSucesso) {
		Processamento proc = processamentoRepository.findOne(idProcessamento);
		proc.setStatus(status);
		proc.setProcessadoComSucesso(processadoComSucesso);
		return processamentoRepository.save(proc);
	}


	public void gravaResultado(Long idProcessamento, String message) {
		Processamento processamento = doAtualizaStatus(idProcessamento, Status.FINALIZADO, true);
		
		EntradaProcessamento entrada = new EntradaProcessamento();
		entrada.setChave("resultado");
		entrada.setEntrada(message);
		entrada.setTipo(Tipo.RESULTADO);
		entrada.setProcessamento(processamento);
		processamento.getEntradasProcessamento().add(entrada);		
		
		processamentoRepository.save(processamento);
	}
	
	public void gravaErro(Long idProcessamento, String message) {
		Processamento processamento = doAtualizaStatus(idProcessamento, Status.FINALIZADO, false);
		
		EntradaProcessamento entrada = new EntradaProcessamento();
		entrada.setChave("erro");
		entrada.setEntrada(message);
		entrada.setTipo(Tipo.ERRO);
		entrada.setProcessamento(processamento);
		processamento.getEntradasProcessamento().add(entrada);		
		
		processamentoRepository.save(processamento);
	}
	

}

