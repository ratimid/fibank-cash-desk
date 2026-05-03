package com.ratimid.fibank_cash_desk.service;

import com.ratimid.fibank_cash_desk.dto.CashOperationRequest;

public interface CashOperationsService {

    void transaction(Long id, CashOperationRequest request);
}
