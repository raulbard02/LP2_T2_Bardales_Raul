package com.examenT2.LP2_T2_Bardales_Raul.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examenT2.LP2_T2_Bardales_Raul.model.ProveedorBardalesRaul;
import com.examenT2.LP2_T2_Bardales_Raul.repository.ProveedorBardalesRaulRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RubroBardalesRaulService {
	private final ProveedorBardalesRaulRepository proveedorRepository;
	public List<ProveedorBardalesRaul> getAll() {
		return proveedorRepository.findAll();
	}
}