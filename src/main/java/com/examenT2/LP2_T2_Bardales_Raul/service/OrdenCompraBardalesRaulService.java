package com.examenT2.LP2_T2_Bardales_Raul.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examenT2.LP2_T2_Bardales_Raul.dto.ResultadoResponse;
import com.examenT2.LP2_T2_Bardales_Raul.model.OrdenCompraBardalesRaul;
import com.examenT2.LP2_T2_Bardales_Raul.repository.OrdenCompraBardalesRaulRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraBardalesRaulService {

	private final OrdenCompraBardalesRaulRepository ordenRepository;

	public List<OrdenCompraBardalesRaul> getAll() {
		return ordenRepository.findAllByOrderByNroOrdenDesc();
	}

	@Transactional
	public ResultadoResponse create(OrdenCompraBardalesRaul orden) {
		try {
			var registrado = ordenRepository.save(orden);
			var mensaje = String.format("Orden de compra Nro. %d registrada.", registrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}

	public OrdenCompraBardalesRaul getOne(Integer id) {
		return ordenRepository.findById(id).orElse(null);
	}

	@Transactional
	public ResultadoResponse update(OrdenCompraBardalesRaul orden) {
		try {
			var registrado = ordenRepository.save(orden);
			var mensaje = String.format("Orden de compra Nro. %d actualizada.", registrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
}