package com.ratimid.fibank_cash_desk.mapper;

import com.ratimid.fibank_cash_desk.dto.BalanceResponse;
import com.ratimid.fibank_cash_desk.entity.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", uses = {BalanceInventoryMapper.class})
public interface BalanceMapper {

    List<BalanceResponse> toResponseList(List<Balance> balanceList);

    @Mapping(source = "currency.currencyCode", target = "currency")
    @Mapping(source = "balanceInventories", target = "denominations")
    @Mapping(source = "balance.cashier.firstName", target = "cashierFirstName")
    @Mapping(source = "balance.cashier.lastName", target = "cashierLastName")
    @Mapping(source = ".", target = "dateFrom", qualifiedByName = "dateFrom")
    @Mapping(source = ".", target = "dateTo", qualifiedByName = "dateTo")
    BalanceResponse toResponse(Balance balance);


    @Named("dateFrom")
    default LocalDateTime dateFrom(Balance balance) {
        if (balance.getCreatedDate() == null && balance.getLastModifiedDate() == null) {
            return null;
        }
        return balance.getLastModifiedDate() == null ? balance.getCreatedDate() : balance.getLastModifiedDate();
    }

    @Named("dateTo")
    default LocalDateTime dateTo(Balance balance) {
        if (balance.getCreatedDate() == null) {
            return null;
        }
        return LocalDateTime.now();
    }
}
