package com.example.k2smoney.api.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public class LancamentoCieloFilter {
    private String bandeira;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private OffsetDateTime dataInicio;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private OffsetDateTime dataFim;

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public OffsetDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(OffsetDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public OffsetDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(OffsetDateTime dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "LancamentoCieloFilter{" +
				"bandeira='" + bandeira + '\'' +
				", dataInicio=" + dataInicio +
				", dataFim=" + dataFim +
				'}';
	}
}
