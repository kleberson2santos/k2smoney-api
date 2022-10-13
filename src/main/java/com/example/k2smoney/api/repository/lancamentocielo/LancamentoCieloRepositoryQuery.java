package com.example.k2smoney.api.repository.lancamentocielo;

import com.example.k2smoney.api.model.Lancamento;
import com.example.k2smoney.api.model.LancamentoCielo;
import com.example.k2smoney.api.repository.filter.LancamentoCieloFilter;
import com.example.k2smoney.api.repository.projection.ResumoLancamentoCielo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoCieloRepositoryQuery {

	public Page<LancamentoCielo> filtrar(LancamentoCieloFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamentoCielo> resumir(LancamentoCieloFilter lancamentoFilter, Pageable pageable);
	
}
