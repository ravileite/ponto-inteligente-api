package com.curso.pontointeligente.api.repositories;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.pontointeligente.api.entities.Empresa;
import com.curso.pontointeligente.api.entities.Funcionario;
import com.curso.pontointeligente.api.entities.Lancamento;
import com.curso.pontointeligente.api.enums.PerfilEnum;
import com.curso.pontointeligente.api.enums.TipoEnum;
import com.curso.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired 
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired 
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;
	
	@Before
	public void setUp() throws Exception{
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		
		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		this.funcionarioId = funcionario.getId();
		
		this.lancamentoRepository.save(obterDadosLancamento(funcionario));
		this.lancamentoRepository.save(obterDadosLancamento(funcionario));
	}
	
	@After
	public void tearDown() throws Exception {
		this.empresaRepository.deleteAll();
	}
	
	
	@Test
	public void testBuscarLancamentosPorFuncionarioId() {
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		
		assertEquals(2, lancamentos.size());
	}
	
	@Test
	public void testBuscarLancamentosPorFuncionarioIdPaginado() {

		PageRequest page = new PageRequest(0, 10);
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, page);
		
		assertEquals(2, lancamentos.getTotalElements());
		
	}
	
	private Lancamento obterDadosLancamento(Funcionario funcionario) {
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
		lancamento.setFuncionario(funcionario);
		return lancamento;
		
	}
	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Compadre José");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
		funcionario.setCpf("12345678901");
		funcionario.setEmail("email@email.com");
		funcionario.setEmpresa(empresa);
		return funcionario;
	}
	
	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("51463645000100");
		empresa.setRazaoSocial("Empresa de Exemplo");
		return empresa;
	}
	
}
