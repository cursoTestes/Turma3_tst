package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {


	public CalculadoraRoyalties(VendaDAO dao, CalculadoraComissao calculadoraComissao){
		this.vendaDAO = dao;
		this.calculadoraComissao = calculadoraComissao;
	}
	
	private VendaDAO vendaDAO ;
	private CalculadoraComissao calculadoraComissao;
	
	
	public Double calcula(int mes, int ano) {
		
		List<Venda> vendas = vendaDAO.obterVendasPorMesEAno(ano, mes);

		double royaltieCalculado = 0.0;
		double faturamentoLiquido = 0.0;
		
		for (Venda venda : vendas) {
			faturamentoLiquido += venda.getValor() - calculadoraComissao.calcula(venda.getValor());
		}
		royaltieCalculado = faturamentoLiquido * 0.2;
				
		return royaltieCalculado;
	}

}
