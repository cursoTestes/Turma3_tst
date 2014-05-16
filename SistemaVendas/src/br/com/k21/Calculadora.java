package br.com.k21;

public class Calculadora {

	private static final double percentualMenorOuIgualDezMil = 0.05;

	public Double calculaComissao(Double valorDaVenda) {
		double result = 0.0;
		
		if (valorDaVenda <= 10000.0) {		
			result = valorDaVenda * percentualMenorOuIgualDezMil;
			result = trataArredondamentoParaBaixo(result);
		} else {
			return 660.0;
		}
		
		return result;
	}

	private double trataArredondamentoParaBaixo(double result) {
		return Math.floor(result*100)/100.0;
	}

}
