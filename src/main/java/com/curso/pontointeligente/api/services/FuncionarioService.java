package com.curso.pontointeligente.api.services;

import java.util.Optional;

import com.curso.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {
	
	/**
	 * Persiste um funcionário no banco de dados.
	 * 
	 * @param funcionario
	 * @return Funcionario
	 */
	
	Funcionario persistir(Funcionario funcionario);
	
	/**
	 * Busca e retorna um funcionário dado um cpf.
	 * 
	 * @param cpf
	 * @return Optional<Funcionario>
	 */
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * Busca e retorna um funcionário dado um email.
	 * 
	 * @param email
	 * @return Optional<Funcionario>
	 */
	
	Optional<Funcionario> buscarPorEmail(String email);
	
	/**
	 * Busca e retorna um funcionário dado um Id.
	 * 
	 * @param id
	 * @return Optional<Funcionario>
	 */
	
	Optional<Funcionario> buscarPorId(Long id);
	
	
}	
