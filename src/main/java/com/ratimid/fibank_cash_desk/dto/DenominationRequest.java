package com.ratimid.fibank_cash_desk.dto;

public class DenominationRequest {

    private Integer value;
    private Integer quantity;

    public DenominationRequest() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
