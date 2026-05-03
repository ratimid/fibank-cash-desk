package com.ratimid.fibank_cash_desk.mapper;

import com.ratimid.fibank_cash_desk.dto.DenominationResponse;
import com.ratimid.fibank_cash_desk.entity.BalanceInventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceInventoryMapper {

    List<DenominationResponse> toResponseList(List<BalanceInventory> balanceInventoryList);

    @Mapping(source = "denomination.value", target = "value")
    @Mapping(source = ".", target = "description", qualifiedByName = "formatDescription")
    DenominationResponse toResponse(BalanceInventory balanceInventory);

    @Named("formatDescription")
    default String formatDescription(BalanceInventory inventory) {
        if (inventory == null || inventory.getDenomination() == null || inventory.getDenomination().getCurrency() == null) {
            return "N/A";
        }
        return "%d X %d %s".formatted(
                inventory.getQuantity(),
                inventory.getDenomination().getValue(),
                inventory.getDenomination().getCurrency().getCurrencyCode()
        );
    }
}
