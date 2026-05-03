package com.ratimid.fibank_cash_desk.controller;

import com.ratimid.fibank_cash_desk.dto.BalanceResponseDto;
import com.ratimid.fibank_cash_desk.service.BalanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cash-balance")
public class CashBalanceController {

    private final BalanceService balanceService;

    public CashBalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/cashiers/{id}")
    public ResponseEntity<BalanceResponseDto> balance(@PathVariable Long id) {
        return new ResponseEntity(balanceService.findAllByCashierId(id), HttpStatus.OK);
    }
}
