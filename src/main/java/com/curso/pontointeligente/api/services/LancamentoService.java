package com.curso.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.curso.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {
	
	/**
	 * Retorna uma lista paginada de lançamentos dado o Id de um determinado funcionário
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	
	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorna um lançamento dado o Id de um determinado funcionário
	 * 
	 * @param Id
	 * @return Optional<Lancamento>
	 */
	
	Optional<Lancamento> buscarPorId(Long Id); 
	
	/**
	 * Persiste um lançamento na base de dados
	 * 
	 * @param lancamento
	 * @return Lancamento
	 */
	
	Lancamento persistir(Lancamento lancamento);
	
	/**
	 * 
	 * Remove um lançamento da base de dados dado um id
	 * 
	 * @param id
	 */
	
	void remover(Long id);
	
}
