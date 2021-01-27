package com.ficticiusclean.veiculos.payload;

import java.math.BigDecimal;

public class VeiculoResponse implements Comparable<VeiculoResponse> {

	private String nome;
	private String marca;
	private String modelo;
	private Integer ano;
	private BigDecimal quantidateCombustivelGasto;
	private BigDecimal valorTotalGastoCombustivel;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public BigDecimal getQuantidateCombustivelGasto() {
		return quantidateCombustivelGasto;
	}

	public void setQuantidateCombustivelGasto(BigDecimal quantidateCombustivelGasto) {
		this.quantidateCombustivelGasto = quantidateCombustivelGasto;
	}

	public BigDecimal getValorTotalGastoCombustivel() {
		return valorTotalGastoCombustivel;
	}

	public void setValorTotalGastoCombustivel(BigDecimal valorTotalGastoCombustivel) {
		this.valorTotalGastoCombustivel = valorTotalGastoCombustivel;
	}

	@Override
	public int compareTo(VeiculoResponse veiculo) {
		return this.getValorTotalGastoCombustivel().compareTo(veiculo.valorTotalGastoCombustivel);
	}

}
