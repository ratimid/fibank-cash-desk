package com.ratimid.fibank_cash_desk.controller;

import com.ratimid.fibank_cash_desk.dto.WithdrawRequest;
import com.ratimid.fibank_cash_desk.dto.WithdrawResponse;
import com.ratimid.fibank_cash_desk.service.CashOperationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cash-operations")
public class CashOperationsController {

    private final CashOperationsService cashOperationsService;

    public CashOperationsController(CashOperationsService cashOperationsService) {
        this.cashOperationsService = cashOperationsService;
    }

   /* @PostMapping("/cashiers/{id}")
    public ResponseEntity<WithdrawResponse> execute(@PathVariable Long cashierId, @RequestBody WithdrawRequest request) {
        cashOperationsService.
    }*/
}
