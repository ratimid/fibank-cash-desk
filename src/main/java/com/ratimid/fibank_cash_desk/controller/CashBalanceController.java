package com.ratimid.fibank_cash_desk.controller;

import com.ratimid.fibank_cash_desk.dto.BalanceResponse;
import com.ratimid.fibank_cash_desk.service.BalanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cash-balance")
public class CashBalanceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CashBalanceController.class);

    private final BalanceService balanceService;

    public CashBalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/cashiers/{id}")
    public ResponseEntity<BalanceResponse> balance(@PathVariable Long id) {
        LOGGER.info("Get balance for cashier with id: {}", id);

        return new ResponseEntity(balanceService.findAllByCashierId(id), HttpStatus.OK);
    }
}
