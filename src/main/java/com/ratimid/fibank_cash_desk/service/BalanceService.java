package com.ratimid.fibank_cash_desk.service;

import com.ratimid.fibank_cash_desk.dto.BalanceResponse;
import java.util.List;

public interface BalanceService {

    List<BalanceResponse> findAllByCashierId(Long cashierId);
}
