package br.com.carlos.designpatterns.strategy.frete;

public class CalculoFreteSpImpl implements CalculoFrete {

	@Override
	public double calcular(double valor) {
		return valor * 2;
	}

}
