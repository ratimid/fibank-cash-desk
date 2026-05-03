package com.ratimid.fibank_cash_desk.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@JsonPropertyOrder({
        "cashierFirstName",
        "cashierLastName",
        "amount",
        "currency",
        "denominationResponse",
        "dateFrom",
        "dateTo"
})
public class BalanceResponse {

    private String cashierFirstName;
    private String cashierLastName;
    private BigDecimal amount;
    private String currency;
    private List<DenominationResponse> denominations;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    public BalanceResponse() {
    }

    public String getCashierFirstName() {
        return cashierFirstName;
    }

    public void setCashierFirstName(String cashierFirstName) {
        this.cashierFirstName = cashierFirstName;
    }

    public String getCashierLastName() {
        return cashierLastName;
    }

    public void setCashierLastName(String cashierLastName) {
        this.cashierLastName = cashierLastName;
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

    public List<DenominationResponse> getDenominations() {
        return denominations;
    }

    public void setDenominations(List<DenominationResponse> denominations) {
        this.denominations = denominations;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }
}
