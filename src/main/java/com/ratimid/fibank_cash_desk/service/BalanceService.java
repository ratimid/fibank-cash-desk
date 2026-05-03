package com.ratimid.fibank_cash_desk.service;

import com.ratimid.fibank_cash_desk.dto.BalanceResponseDto;

import java.util.List;

public interface BalanceService {

    List<BalanceResponseDto> findAllByCashierId(Long cashierId);
}
