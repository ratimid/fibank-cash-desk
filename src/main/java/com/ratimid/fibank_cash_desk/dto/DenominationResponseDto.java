package com.ratimid.fibank_cash_desk.dto;

public class DenominationResponseDto {

    private Integer denominationValue;
    private Integer quantity;
    private String description;

    public DenominationResponseDto() {
    }

    public Integer getDenominationValue() {
        return denominationValue;
    }

    public void setDenominationValue(Integer denominationValue) {
        this.denominationValue = denominationValue;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
