package br.com.k21;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	VendaDAO dao;
	CalculadoraComissao calcComissao;
	
	@Before
	public void setup() {
		dao = Mockito.mock(VendaDAO.class);
		calcComissao = Mockito.mock(CalculadoraComissao.class);
	}
	

	@Test
	public void mes_sem_vendas() {
		
		int mes = 5;
		int ano = 2014;
		Double valorEsperado = 0.0;
		
		when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(new ArrayList<Venda>());
		
		Double retorno = new CalculadoraRoyalties(dao,calcComissao).calcula(mes, ano);
		
		assertEquals(valorEsperado , retorno);
	}
	
	
	@Test
	public void mes_ano_com_uma_venda() {
		
		int mes = 4;
		int ano = 2013;
		Double valorEsperado = 1900.0;
		
		Venda venda = new Venda(1, 1, mes, ano, 10000);
		when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(Arrays.asList(venda));
		when(calcComissao.calcula(10000.0)).thenReturn(500.0);
		
		Double retorno = new CalculadoraRoyalties(dao,calcComissao).calcula(mes, ano);
		
		assertEquals(valorEsperado , retorno);
	}
	
	@Test
	public void mes_ano_com_duas_vendas() {
		
		int mes = 3;
		int ano = 2013;
		Double valorEsperado = 38.0;
		
		Venda venda1 = new Venda(1, 1, mes, ano, 100);
		Venda venda2 = new Venda(2, 1, mes, ano, 100);
		when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(Arrays.asList(venda1,venda2));
		when(calcComissao.calcula(100.0)).thenReturn(5.0);
		
		Double retorno = new CalculadoraRoyalties(dao,calcComissao).calcula(mes, ano);
		
		assertEquals(valorEsperado , retorno);
	}
		

	@Test
	public void mes_ano_com_uma_venda_mas_Zerando_Comissao() {
		
		int mes = 1;
		int ano = 2013;
		Double valorEsperado = 20.0;
		
		Venda venda1 = new Venda(1, 1, mes, ano, 100);

		when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(Arrays.asList(venda1));
		when(calcComissao.calcula(100.0)).thenReturn(0.0);
		
		Double retorno = new CalculadoraRoyalties(dao,calcComissao).calcula(mes, ano);
		
		assertEquals(valorEsperado , retorno);
		
		Mockito.verify(calcComissao, Mockito.atLeastOnce()).calcula(100.0);
		
	}
}
;