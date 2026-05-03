package com.ratimid.fibank_cash_desk.service;

import com.ratimid.fibank_cash_desk.dto.WithdrawRequest;
import com.ratimid.fibank_cash_desk.dto.WithdrawResponse;
import com.ratimid.fibank_cash_desk.entity.Balance;
import com.ratimid.fibank_cash_desk.repository.BalanceRepository;
import org.springframework.stereotype.Service;

@Service
public class CashOperationsServiceImpl implements CashOperationsService {

    private final BalanceRepository balanceRepository;

    public CashOperationsServiceImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

   /* @Override
    public WithdrawResponse withdrawByCashierId(Long cashierId, WithdrawRequest request) {
        Balance balance = balanceRepository.findByCashierId(cashierId);
        return null;
    }*/
}
