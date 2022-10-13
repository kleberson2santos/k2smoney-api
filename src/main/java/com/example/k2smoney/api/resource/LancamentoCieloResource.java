package com.example.k2smoney.api.resource;

import com.example.k2smoney.api.dto.Anexo;
import com.example.k2smoney.api.dto.LancamentoEstatisticaCategoria;
import com.example.k2smoney.api.dto.LancamentoEstatisticaDia;
import com.example.k2smoney.api.event.RecursoCriadoEvent;
import com.example.k2smoney.api.exceptionHandler.K2smoneyExceptionHandler;
import com.example.k2smoney.api.model.Lancamento;
import com.example.k2smoney.api.model.LancamentoCielo;
import com.example.k2smoney.api.model.LancamentoCielo_;
import com.example.k2smoney.api.repository.LancamentoCieloRepository;
import com.example.k2smoney.api.repository.LancamentoRepository;
import com.example.k2smoney.api.repository.filter.LancamentoCieloFilter;
import com.example.k2smoney.api.repository.filter.LancamentoFilter;
import com.example.k2smoney.api.repository.projection.ResumoLancamento;
import com.example.k2smoney.api.repository.projection.ResumoLancamentoCielo;
import com.example.k2smoney.api.service.LancamentoCieloService;
import com.example.k2smoney.api.service.LancamentoService;
import com.example.k2smoney.api.service.exception.PessoaInexistenteOuInativaException;
import com.example.k2smoney.api.storage.S3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos-cielo")
public class LancamentoCieloResource {

	@Autowired
	private LancamentoCieloRepository lancamentoRepository;
		
	@Autowired
	private LancamentoCieloService lancamentoService;

	@Autowired
	private ApplicationEventPublisher publisher;
    
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and hasAuthority('SCOPE_read')")
	public Page<LancamentoCielo> pesquisar(LancamentoCieloFilter lancamentoFilter, Pageable pageable) {
		return lancamentoRepository.filtrar(lancamentoFilter, pageable);
	}
		
	@GetMapping(params = "resumo")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and hasAuthority('SCOPE_read')")
	public Page<ResumoLancamentoCielo> resumir(LancamentoCieloFilter lancamentoFilter, Pageable pageable) {
		return lancamentoRepository.resumir(lancamentoFilter, pageable);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and hasAuthority('SCOPE_read')")
	public ResponseEntity<LancamentoCielo> buscarPeloCodigo(@PathVariable Long id) {
		Optional<LancamentoCielo> lancamento = lancamentoRepository.findById(id);
		return lancamento.isPresent() ? ResponseEntity.ok(lancamento.get()) : ResponseEntity.notFound().build();
	}
		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<LancamentoCielo> criar(@Valid @RequestBody LancamentoCielo lancamento, HttpServletResponse response) {
		LancamentoCielo lancamentoSalvo = lancamentoService.salvar(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO') and hasAuthority('SCOPE_write')")
	public void remover(@PathVariable Long id) {
		lancamentoRepository.deleteById(id);
	}

		
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO')")
	public ResponseEntity<LancamentoCielo> atualizar(@PathVariable Long codigo, @Valid @RequestBody LancamentoCielo lancamento) {
		try {
			LancamentoCielo lancamentoSalvo = lancamentoService.atualizar(codigo, lancamento);
			return ResponseEntity.ok(lancamentoSalvo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
