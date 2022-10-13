package com.example.k2smoney.api.repository.lancamento;

import com.example.k2smoney.api.dto.LancamentoEstatisticaCategoria;
import com.example.k2smoney.api.dto.LancamentoEstatisticaDia;
import com.example.k2smoney.api.dto.LancamentoEstatisticaPessoa;
import com.example.k2smoney.api.model.Lancamento;
import com.example.k2smoney.api.repository.filter.LancamentoFilter;
import com.example.k2smoney.api.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface LancamentoRepositoryQuery {
	
	public List<LancamentoEstatisticaPessoa> porPessoa(LocalDate inicio, LocalDate fim);
	public List<LancamentoEstatisticaCategoria> porCategoria(LocalDate mesReferencia);
	public List<LancamentoEstatisticaDia> porDia(LocalDate mesReferencia);

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
	
}
