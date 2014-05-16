package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	@Test
	public void calcula_comissao_da_venda_de_100_retorna_5() {
		Double valorDaVenda = 100.0;
		Double valorEsperado = 5.0;
		
		Double comissao = new Calculadora().calculaComissao(valorDaVenda);
				
		assertEquals(valorEsperado, comissao);
	}
	
	@Test
	public void calcula_comissao_da_venda_de_1000_retorna_50() {
		Double valorDaVenda = 1000.0;
		Double valorEsperado = 50.0;
		
		Double comissao = new Calculadora().calculaComissao(valorDaVenda);
				
		assertEquals(valorEsperado, comissao);
	}

	@Test
	public void calcula_comissao_da_venda_de_10000_retorna_500() {
		Double valorDaVenda = 10000.0;
		Double valorEsperado = 500.0;
		
		Double comissao = new Calculadora().calculaComissao(valorDaVenda);
				
		assertEquals(valorEsperado, comissao);
	}
	
	@Test
	public void calcula_comissao_da_venda_de_1_retorna_5_centavos() {
		Double valorDaVenda = 1.0;
		Double valorEsperado = 0.05;
		
		Double comissao = new Calculadora().calculaComissao(valorDaVenda);
				
		assertEquals(valorEsperado, comissao);
	}
	@Test
	public void calcula_comissao_da_venda_de_1_centavo_retorna_0_centavo() {
		Double valorDaVenda = 0.01;
		Double valorEsperado = 0.0;
		
		Double comissao = new Calculadora().calculaComissao(valorDaVenda);
				
		assertEquals(valorEsperado, comissao);
	}
	
	@Test
	public void calcula_comissao_da_venda_de_55_59_retorna_2_77() {
		Double valorDaVenda = 55.59;
		Double valorEsperado = 2.77;
		
		Double comissao = new Calculadora().calculaComissao(valorDaVenda);
				
		assertEquals(valorEsperado, comissao);
	}
	
	@Test
	public void calcula_comissao_da_venda_de_11000_retorna_660() {
		Double valorDaVenda = 11000.0;
		Double valorEsperado = 660.0;
		
		Double comissao = new Calculadora().calculaComissao(valorDaVenda);
				
		assertEquals(valorEsperado, comissao);
	}
	
}
