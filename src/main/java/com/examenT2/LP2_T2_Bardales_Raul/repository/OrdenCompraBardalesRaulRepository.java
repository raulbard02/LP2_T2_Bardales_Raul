package com.examenT2.LP2_T2_Bardales_Raul.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examenT2.LP2_T2_Bardales_Raul.model.OrdenCompraBardalesRaul;

public interface OrdenCompraBardalesRaulRepository extends JpaRepository<OrdenCompraBardalesRaul, Integer> {
	List<OrdenCompraBardalesRaul> findAllByOrderByNroOrdenDesc();
}