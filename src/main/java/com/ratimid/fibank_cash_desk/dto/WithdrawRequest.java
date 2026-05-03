package com.ratimid.fibank_cash_desk.dto;

public class WithdrawRequest {

    private Integer amount;
    private String currency;

    public WithdrawRequest() {
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
}
