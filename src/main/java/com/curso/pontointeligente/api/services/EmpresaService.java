package com.curso.pontointeligente.api.services;

import java.util.Optional;

import com.curso.pontointeligente.api.entities.Empresa;

public interface EmpresaService {
	
	/**
	 * Retorna uma empresa dado um cnpj
	 * 
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	
	Optional <Empresa> buscarPorCnpj(String cnpj);
	
	/**
	 * Persiste uma empresa no banco de dados
	 * 
	 * @param empresa
	 * @return Empresa
	 */
	
	Empresa persistir(Empresa empresa);
}	
