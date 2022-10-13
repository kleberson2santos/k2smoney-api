package com.example.k2smoney.api.repository.projection;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ResumoLancamentoCielo {

	private Long id;

	private String cardBrand;

	private String paymentType;

	private String channel;

	private OffsetDateTime date;

	private String status;

	private BigDecimal grossAmount;

	private BigDecimal netAmount;

	public ResumoLancamentoCielo(Long id, String cardBrand, String paymentType, String channel, OffsetDateTime date, String status, BigDecimal grossAmount, BigDecimal netAmount) {
		this.id = id;
		this.cardBrand = cardBrand;
		this.paymentType = paymentType;
		this.channel = channel;
		this.date = date;
		this.status = status;
		this.grossAmount = grossAmount;
		this.netAmount = netAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardBrand() {
		return cardBrand;
	}

	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public OffsetDateTime getDate() {
		return date;
	}

	public void setDate(OffsetDateTime date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}
}
