package com.oliveira.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.oliveira.api.entities.Empresa;
import com.oliveira.api.repositories.EmpresaRepository;
import com.oliveira.api.services.ExemploService;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ExemploService exemploService;
	
	@Value("${paginacao.qtde_por_pagina}")
	private int qtdePorPagina;
	

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		System.out.println("Meu primeiro projeto...");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		
		return args -> {
			
			this.exemploService.testarServico();
			
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Oliveira TI");
			empresa.setCnpj("61592479000197");
			this.empresaRepository.save(empresa);
			
			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Optional<Empresa> empresaDb = empresaRepository.findById(1L);
			System.out.println("Empresa por ID: " + empresaDb);
			
//			empresaDb.setRazaoSocial("Oliveira TI Web");
//			this.empresaRepository.save(empresaDb);
			
			Empresa empresaCnpj = empresaRepository.findByCnpj("61592479000197");
			System.out.println("Empresa por CNPJ:" + empresaCnpj);
			
			empresaCnpj.setRazaoSocial("Oliveira TI Web");
			this.empresaRepository.save(empresaCnpj);
			
			System.out.println("Empresa por CNPJ:" + empresaCnpj);			

			// TODO - Erro ao deletar por ID
     		//this.empresaRepository.deleteById(1L);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());
			
			
			System.out.println("# Quantidade por página = " + this.qtdePorPagina);
			
//			String senha = "123456";
//			
//			String senhaEncoded = SenhaUtils.gerarBCrypt(senha);
//			System.out.println ("# Senha encoded: " + senhaEncoded);
//			
//			senhaEncoded = SenhaUtils.gerarBCrypt(senha);
//			System.out.println ("# Senha encoded novamente: " + senhaEncoded);
//			
//			System.out.println ("# Senha válida: " + SenhaUtils.senhaValida(senha, senhaEncoded));
			
		};
		
	}

}
