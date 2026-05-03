package com.ratimid.fibank_cash_desk.dto;

import java.math.BigDecimal;
import java.util.List;


public class BalanceResponseDto {

    private BigDecimal amount;
    private String currency;
    private List<DenominationResponseDto> denominationResponseDto;

    public BalanceResponseDto() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<DenominationResponseDto> getDenominationResponseDto() {
        return denominationResponseDto;
    }

    public void setDenominationResponseDto(List<DenominationResponseDto> denominationResponseDto) {
        this.denominationResponseDto = denominationResponseDto;
    }
}
