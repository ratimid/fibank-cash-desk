package com.ratimid.fibank_cash_desk.service;

import com.ratimid.fibank_cash_desk.dto.CashOperationRequest;
import com.ratimid.fibank_cash_desk.dto.DenominationRequest;
import com.ratimid.fibank_cash_desk.entity.Balance;
import com.ratimid.fibank_cash_desk.entity.BalanceInventory;
import com.ratimid.fibank_cash_desk.entity.CashOperation;
import com.ratimid.fibank_cash_desk.repository.BalanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class CashOperationsServiceImpl implements CashOperationsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CashOperationsServiceImpl.class);

    private final BalanceRepository balanceRepository;

    public CashOperationsServiceImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void transaction(Long id, CashOperationRequest request) {

        List<Balance> balanceList = balanceRepository.findByCashierId(id);

        Balance balance = balanceList.stream()
                .filter(b -> b.getCurrency().getCurrencyCode().equals(request.getCurrency()))
                .findFirst()
                .orElseThrow(() -> {
                    LOGGER.error("Balance not found for cashierId: {} and currency: {}", id, request.getCurrency());
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Balance not found");
                });

        if (request.getOperationType() == CashOperation.WITHDRAW) {
            if (balance.getAmount().compareTo(request.getAmount()) < 0) {
                LOGGER.error("Withdrawal failed: Insufficient balance for cashierId: {}. Available: {}, Requested: {}",
                        id, balance.getAmount(), request.getAmount());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient total balance");
            }
            balance.setAmount(balance.getAmount().subtract(request.getAmount()));
        } else {
            balance.setAmount(balance.getAmount().add(request.getAmount()));
        }

        try {
            updateBalanceInventory(request, balance);
            balanceRepository.save(balance);
            LOGGER.info("Successfully processed {} for cashierId: {}. New balance: {}",
                    request.getOperationType(), id, balance.getAmount());

        } catch (ResponseStatusException e) {
            LOGGER.error("Inventory update failed for cashierId: {}. Reason: {}", id, e.getReason());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Unexpected error during operation for cashierId: {}", id, e);
            throw e;
        }
    }

    private void updateBalanceInventory(CashOperationRequest request, Balance balance) {
        for (DenominationRequest req : request.getDenominationRequests()) {
            BalanceInventory inventory = balance.getBalanceInventories().stream()
                    .filter(bi -> bi.getDenomination().getValue().equals(req.getValue()))
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Denomination " + req.getValue() + " not supported for this balance"
                    ));

            if (request.getOperationType() == CashOperation.WITHDRAW) {
                if (inventory.getQuantity() < req.getQuantity()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Insufficient quantity of denomination: " + req.getValue());
                }
                inventory.setQuantity(inventory.getQuantity() - req.getQuantity());
            } else {
                inventory.setQuantity(inventory.getQuantity() + req.getQuantity());
            }
        }
    }
}
