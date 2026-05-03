package com.ratimid.fibank_cash_desk.dto;

import java.util.List;

public class WithdrawResponse {

    private Integer amount;
    private String currency;
    private List<DenominationResponse> denominationResponse;

    public WithdrawResponse() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<DenominationResponse> getDenominationResponse() {
        return denominationResponse;
    }

    public void setDenominationResponse(List<DenominationResponse> denominationResponse) {
        this.denominationResponse = denominationResponse;
    }
}
