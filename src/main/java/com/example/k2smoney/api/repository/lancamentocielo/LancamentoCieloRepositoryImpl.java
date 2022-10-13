package com.example.k2smoney.api.repository.lancamentocielo;

import com.example.k2smoney.api.dto.LancamentoEstatisticaCategoria;
import com.example.k2smoney.api.dto.LancamentoEstatisticaDia;
import com.example.k2smoney.api.dto.LancamentoEstatisticaPessoa;
import com.example.k2smoney.api.model.*;
import com.example.k2smoney.api.repository.filter.LancamentoCieloFilter;
import com.example.k2smoney.api.repository.filter.LancamentoFilter;
import com.example.k2smoney.api.repository.projection.ResumoLancamento;
import com.example.k2smoney.api.repository.projection.ResumoLancamentoCielo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class LancamentoCieloRepositoryImpl implements LancamentoCieloRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<LancamentoCielo> filtrar(LancamentoCieloFilter lancamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<LancamentoCielo> criteria = builder.createQuery(LancamentoCielo.class);
		Root<LancamentoCielo> root = criteria.from(LancamentoCielo.class);
		
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<LancamentoCielo> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		System.out.println("query.getResultList():"+query.getResultList());
		return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
	}

	private Predicate[] criarRestricoes(LancamentoCieloFilter lancamentoFilter, CriteriaBuilder builder,
			Root<LancamentoCielo> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(lancamentoFilter.getBandeira())) {
			predicates.add(builder.like(
					builder.lower(root.get("cardBrand")), "%" + lancamentoFilter.getBandeira().toLowerCase() + "%"));
		}

		if (lancamentoFilter.getDataInicio() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get("date"), (lancamentoFilter.getDataInicio())));
		}

		if (lancamentoFilter.getDataFim() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("date"), lancamentoFilter.getDataFim()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}


	@Override
	public Page<ResumoLancamentoCielo> resumir(LancamentoCieloFilter lancamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoLancamentoCielo> criteria = builder.createQuery(ResumoLancamentoCielo.class);
		Root<LancamentoCielo> root = criteria.from(LancamentoCielo.class);

		criteria.select(builder.construct(ResumoLancamentoCielo.class
				, root.get(LancamentoCielo_.ID)
				, root.get(LancamentoCielo_.CARD_BRAND)
				, root.get(LancamentoCielo_.PAYMENT_TYPE)
				, root.get(LancamentoCielo_.CHANNEL)
				, root.get(LancamentoCielo_.DATE)
				, root.get(LancamentoCielo_.STATUS)
				, root.get(LancamentoCielo_.GROSS_AMOUNT)
				, root.get(LancamentoCielo_.NET_AMOUNT)
		));

		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<ResumoLancamentoCielo> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(LancamentoCieloFilter lancamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<LancamentoCielo> root = criteria.from(LancamentoCielo.class);
		
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
