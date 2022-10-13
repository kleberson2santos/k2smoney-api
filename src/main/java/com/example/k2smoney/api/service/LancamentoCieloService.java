package com.example.k2smoney.api.service;

import com.example.k2smoney.api.dto.LancamentoEstatisticaPessoa;
import com.example.k2smoney.api.mail.Mailer;
import com.example.k2smoney.api.model.Lancamento;
import com.example.k2smoney.api.model.LancamentoCielo;
import com.example.k2smoney.api.model.Pessoa;
import com.example.k2smoney.api.model.Usuario;
import com.example.k2smoney.api.repository.LancamentoCieloRepository;
import com.example.k2smoney.api.repository.LancamentoRepository;
import com.example.k2smoney.api.repository.PessoaRepository;
import com.example.k2smoney.api.repository.UsuarioRepository;
import com.example.k2smoney.api.service.exception.PessoaInexistenteOuInativaException;
import com.example.k2smoney.api.storage.S3;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Service
public class LancamentoCieloService {

	private static final String DESTINATARIOS = "ROLE_PESQUISAR_LANCAMENTO";

	private static final Logger logger = LoggerFactory.getLogger(LancamentoCieloService.class);

	@Autowired
	private LancamentoCieloRepository lancamentoCieloRepository;

	public LancamentoCielo salvar(LancamentoCielo lancamento) {

		return lancamentoCieloRepository.save(lancamento);
	}

	public LancamentoCielo atualizar(Long codigo, LancamentoCielo lancamento) {
		LancamentoCielo lancamentoSalvo = buscarLancamentoExistente(codigo);

		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");

		return lancamentoCieloRepository.save(lancamentoSalvo);
	}

	private LancamentoCielo buscarLancamentoExistente(Long codigo) {
		return lancamentoCieloRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException());
	}	
	
}
