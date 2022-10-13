package com.example.k2smoney.api.repository.listener;

import com.example.k2smoney.api.K2smoneyApiApplication;
import com.example.k2smoney.api.model.Lancamento;
import com.example.k2smoney.api.storage.S3;
import org.springframework.util.StringUtils;

import javax.persistence.PostLoad;

public class LancamentoAnexoListener {

	@PostLoad
	public void postLoad(Lancamento lancamento) {
		if (StringUtils.hasText(lancamento.getAnexo())) {
			S3 s3 = K2smoneyApiApplication.getBean(S3.class);
			lancamento.setUrlAnexo(s3.configurarUrl(lancamento.getAnexo()));
		}
	}

}
