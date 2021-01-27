package com.ficticiusclean.veiculos.factory;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.ficticiusclean.veiculos.model.Veiculo;
import com.ficticiusclean.veiculos.payload.VeiculoResponse;

@Component
public class VeiculoFactory {

	public VeiculoResponse create(Veiculo veiculo, Double totalCombustivel, Double totalValor) {

		VeiculoResponse response = new VeiculoResponse();

		response.setAno(veiculo.getDataFabricacao().getYear());
		response.setMarca(veiculo.getMarca());
		response.setModelo(veiculo.getModelo());
		response.setNome(veiculo.getNome());
		response.setQuantidateCombustivelGasto(BigDecimal.valueOf(totalCombustivel).setScale(2, RoundingMode.FLOOR));
		response.setValorTotalGastoCombustivel(BigDecimal.valueOf(totalValor).setScale(2, RoundingMode.FLOOR));

		return response;
	}

}
