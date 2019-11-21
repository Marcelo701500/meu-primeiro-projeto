package com.oliveira.api;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class MeuPrimeiroProjetoApplicationTests {
	
	@Value("${paginacao.qtde_por_pagina}")
	private int qtdePorPagina;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCarregarContextoTeste() {
		assertEquals(100, qtdePorPagina);
	}

}
