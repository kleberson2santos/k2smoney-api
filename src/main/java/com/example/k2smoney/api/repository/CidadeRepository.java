package com.example.k2smoney.api.repository;

import com.example.k2smoney.api.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	List<Cidade> findByEstadoCodigo(Long estadoCodigo);

}
