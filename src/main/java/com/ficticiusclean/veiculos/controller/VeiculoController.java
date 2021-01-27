package com.ficticiusclean.veiculos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ficticiusclean.veiculos.exception.VeiculoNotFoundException;
import com.ficticiusclean.veiculos.model.Veiculo;
import com.ficticiusclean.veiculos.payload.VeiculoRequest;
import com.ficticiusclean.veiculos.payload.VeiculoResponse;
import com.ficticiusclean.veiculos.repository.VeiculoRepository;
import com.ficticiusclean.veiculos.service.VeiculoService;

@RestController
@RequestMapping(path = "/veiculos")
public class VeiculoController {

	private VeiculoService veiculoService;
	private VeiculoRepository veiculoRepository;

	public VeiculoController(VeiculoService veiculoService, VeiculoRepository veiculoRepository) {
		this.veiculoService = veiculoService;
		this.veiculoRepository = veiculoRepository;
	}

	@GetMapping(path = "/{id}")
	public Veiculo buscarVeiculo(@PathVariable("id") Long id) {
		try {
			return veiculoRepository.findById(id).get();
		} catch (Exception e) {
			throw new VeiculoNotFoundException("Não existe um veículo com o Id informado: " + id);
		}
	}

	@GetMapping
	public List<Veiculo> listarTodos() {
		return veiculoRepository.findAll();
	}

	@GetMapping(path = "/find/{nome}")
	public List<Veiculo> buscaPorNome(@PathVariable("nome") String nome) {
		List<Veiculo> veiculos = veiculoRepository.findByNome(nome);

		if (veiculos.isEmpty()) {
			throw new VeiculoNotFoundException("Não existe um veículo com o nome informado: " + nome);
		} else {
			return veiculos;
		}
	}

	@GetMapping(path = "/previsaoGastos")
	public List<VeiculoResponse> previsaoGastos(@RequestBody VeiculoRequest request) {
		return veiculoService.listarPrevisaoGastos(request);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionar(@RequestBody Veiculo veiculo) {
		return veiculoService.save(veiculo);
	}

	@PutMapping(path = "/{id}")
	public void atualizar(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
		veiculoService.atualizar(id, veiculo);
	}

	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable("id") Long id) {
		veiculoService.excluir(id);
	}

}
