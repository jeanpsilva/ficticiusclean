package com.ficticiusclean.veiculos.service;

import java.util.List;

import com.ficticiusclean.veiculos.model.Veiculo;
import com.ficticiusclean.veiculos.payload.VeiculoRequest;
import com.ficticiusclean.veiculos.payload.VeiculoResponse;

public interface VeiculoService {

	public Veiculo save(Veiculo veiculo);

	public void atualizar(Long id, Veiculo veiculo);

	public void excluir(Long id);

	public List<VeiculoResponse> listarPrevisaoGastos(VeiculoRequest veiculoRequest);

}
