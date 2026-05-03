package com.ratimid.fibank_cash_desk.mapper;

import com.ratimid.fibank_cash_desk.dto.BalanceResponseDto;
import com.ratimid.fibank_cash_desk.entity.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BalanceInventoryMapper.class})
public interface BalanceMapper {

    List<BalanceResponseDto> toResponseList(List<Balance> balanceList);

    @Mapping(source = "currency.currencyCode", target = "currency")
    @Mapping(source = "balanceInventories", target = "denominationResponseDto")
    BalanceResponseDto toResponse(Balance balance);
}
