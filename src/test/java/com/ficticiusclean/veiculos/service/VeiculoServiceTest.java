package com.ficticiusclean.veiculos.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ficticiusclean.veiculos.model.Veiculo;
import com.ficticiusclean.veiculos.payload.VeiculoRequest;
import com.ficticiusclean.veiculos.payload.VeiculoResponse;
import com.ficticiusclean.veiculos.repository.VeiculoRepository;

@SpringBootTest
public class VeiculoServiceTest {

	@Autowired
	private VeiculoService service;

	@MockBean
	private VeiculoRepository repository;

	@Test
	public void shoudReturnPrevisaoGastos() {

		List<Veiculo> veiculosTest = new ArrayList<Veiculo>();
		Veiculo veiculoTest = new Veiculo();

		veiculoTest.setId(999L);
		veiculoTest.setNome("Uno");
		veiculoTest.setMarca("Fiat");
		veiculoTest.setModelo("Fire");
		veiculoTest.setDataFabricacao(LocalDate.of(2020, 01, 01));
		veiculoTest.setConsumoMedioCidade(10.5);
		veiculoTest.setConsumoMedioRodovia(15.5);
		veiculosTest.add(veiculoTest);

		when(repository.findAll()).thenReturn(veiculosTest);

		VeiculoRequest request = new VeiculoRequest();
		request.setKmPercorridoCidade(137.42);
		request.setKmPercorridoRodovia(310.25);
		request.setPreco(5.3);

		List<VeiculoResponse> responses = service.listarPrevisaoGastos(request);

		assertNotNull(responses);

		for (VeiculoResponse veiculoResponse : responses) {
			assertEquals(veiculoResponse.getAno().toString(), "2020");
			assertEquals(veiculoResponse.getMarca(), "Fiat");
			assertEquals(veiculoResponse.getModelo(), "Fire");
			assertEquals(veiculoResponse.getNome(), "Uno");
			assertTrue(veiculoResponse.getQuantidateCombustivelGasto().compareTo(BigDecimal.valueOf(33.10)) == 0);
			assertTrue(veiculoResponse.getValorTotalGastoCombustivel().compareTo(BigDecimal.valueOf(175.44)) == 0);

		}

	}

}
