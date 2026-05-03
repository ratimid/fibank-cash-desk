package com.ratimid.fibank_cash_desk.service;

import com.ratimid.fibank_cash_desk.dto.BalanceResponseDto;
import com.ratimid.fibank_cash_desk.entity.Balance;
import com.ratimid.fibank_cash_desk.mapper.BalanceInventoryMapper;
import com.ratimid.fibank_cash_desk.mapper.BalanceMapper;
import com.ratimid.fibank_cash_desk.repository.BalanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;

    public BalanceServiceImpl(BalanceRepository balanceRepository,
                              BalanceMapper balanceMapper) {
        this.balanceRepository = balanceRepository;
        this.balanceMapper = balanceMapper;
    }

    @Override
    public List<BalanceResponseDto> findAllByCashierId(Long cashierId) {
        List<Balance> balanceList = balanceRepository.findByCashierId(cashierId);

        return balanceMapper.toResponseList(balanceList);
    }
}
