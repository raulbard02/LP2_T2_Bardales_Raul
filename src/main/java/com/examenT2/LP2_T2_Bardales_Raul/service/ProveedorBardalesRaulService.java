package com.examenT2.LP2_T2_Bardales_Raul.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examenT2.LP2_T2_Bardales_Raul.model.RubroBardalesRaul;
import com.examenT2.LP2_T2_Bardales_Raul.repository.RubroBardalesRaulRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorBardalesRaulService {
	private final RubroBardalesRaulRepository rubroRepository;
	public List<RubroBardalesRaul> getAll() {
		return rubroRepository.findAll();
	}
}