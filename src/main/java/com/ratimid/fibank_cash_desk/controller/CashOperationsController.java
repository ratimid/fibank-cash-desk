package com.ratimid.fibank_cash_desk.controller;

import com.ratimid.fibank_cash_desk.dto.CashOperationRequest;
import com.ratimid.fibank_cash_desk.service.CashOperationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cash-operations")
public class CashOperationsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CashOperationsController.class);

    private final CashOperationsService cashOperationsService;

    public CashOperationsController(CashOperationsService cashOperationsService) {
        this.cashOperationsService = cashOperationsService;
    }

    @PostMapping("/cashiers/{id}")
    public ResponseEntity<Void> transaction(@PathVariable Long id, @RequestBody CashOperationRequest request) {
        LOGGER.info("Cash operation execution for cashiers with id: {}", id);

        cashOperationsService.transaction(id, request);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
