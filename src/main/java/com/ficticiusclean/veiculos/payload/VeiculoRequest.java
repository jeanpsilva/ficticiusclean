package com.ficticiusclean.veiculos.payload;

public class VeiculoRequest {

	private Double preco;
	private Double kmPercorridoCidade;
	private Double kmPercorridoRodovia;

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getKmPercorridoCidade() {
		return kmPercorridoCidade;
	}

	public void setKmPercorridoCidade(Double kmPercorridoCidade) {
		this.kmPercorridoCidade = kmPercorridoCidade;
	}

	public Double getKmPercorridoRodovia() {
		return kmPercorridoRodovia;
	}

	public void setKmPercorridoRodovia(Double kmPercorridoRodovia) {
		this.kmPercorridoRodovia = kmPercorridoRodovia;
	}

}
