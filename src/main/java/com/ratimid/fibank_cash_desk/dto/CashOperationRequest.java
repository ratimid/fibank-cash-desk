package com.ratimid.fibank_cash_desk.dto;

import com.ratimid.fibank_cash_desk.entity.CashOperation;

import java.math.BigDecimal;
import java.util.List;

public class CashOperationRequest {

    private BigDecimal amount;
    private String currency;
    private CashOperation operationType;
    private List<DenominationRequest> denominationRequests;

    public CashOperationRequest() {
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

    public CashOperation getOperationType() {
        return operationType;
    }

    public void setOperationType(CashOperation operationType) {
        this.operationType = operationType;
    }

    public List<DenominationRequest> getDenominationRequests() {
        return denominationRequests;
    }

    public void setDenominationRequests(List<DenominationRequest> denominationRequests) {
        this.denominationRequests = denominationRequests;
    }
}
