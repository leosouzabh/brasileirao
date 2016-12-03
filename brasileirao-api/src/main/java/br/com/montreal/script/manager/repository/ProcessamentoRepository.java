package br.com.montreal.script.manager.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.montreal.script.manager.model.Processamento;

public interface ProcessamentoRepository extends PagingAndSortingRepository<Processamento, Long> {

	
}
