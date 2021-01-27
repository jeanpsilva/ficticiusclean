package com.ficticiusclean.veiculos.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ficticiusclean.veiculos.exception.VeiculoNotFoundException;
import com.ficticiusclean.veiculos.factory.VeiculoFactory;
import com.ficticiusclean.veiculos.model.Veiculo;
import com.ficticiusclean.veiculos.payload.VeiculoRequest;
import com.ficticiusclean.veiculos.payload.VeiculoResponse;
import com.ficticiusclean.veiculos.repository.VeiculoRepository;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	private VeiculoRepository veiculoRepository;
	private VeiculoFactory veiculoFactory;

	public VeiculoServiceImpl(VeiculoRepository veiculoRepository, VeiculoFactory veiculoFactory) {
		this.veiculoRepository = veiculoRepository;
		this.veiculoFactory = veiculoFactory;
	}

	@Override
	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public void atualizar(Long id, Veiculo veiculo) {

		if (!veiculoRepository.existsById(id)) {
			throw new VeiculoNotFoundException("Não existe um veículo com o Id informado: " + id);
		} else {
			veiculo.setId(id);
			veiculoRepository.save(veiculo);
		}
	}

	public void excluir(Long id) {
		if (!veiculoRepository.existsById(id)) {
			throw new VeiculoNotFoundException("Não existe um veículo com o Id informado: " + id);
		} else {
			veiculoRepository.deleteById(id);
		}
	}

	@Override
	public List<VeiculoResponse> listarPrevisaoGastos(VeiculoRequest veiculoRequest) {

		List<VeiculoResponse> veiculosResponse = new ArrayList<VeiculoResponse>();

		Double preco = veiculoRequest.getPreco();
		Double kmPercorridoCidade = veiculoRequest.getKmPercorridoCidade();
		Double kmPercorridoRodovia = veiculoRequest.getKmPercorridoRodovia();

		List<Veiculo> veiculos = veiculoRepository.findAll();

		for (Veiculo veiculo : veiculos) {
			Double totalConsumoCidade = kmPercorridoCidade / veiculo.getConsumoMedioCidade();
			Double totalConsumoRodovia = kmPercorridoRodovia / veiculo.getConsumoMedioRodovia();

			Double consumoTotal = totalConsumoCidade + totalConsumoRodovia;

			Double precoTotal = consumoTotal * preco;

			VeiculoResponse veiculoResponse = veiculoFactory.create(veiculo, consumoTotal, precoTotal);

			veiculosResponse.add(veiculoResponse);

		}

		Collections.sort(veiculosResponse);

		return veiculosResponse;
	}

}
