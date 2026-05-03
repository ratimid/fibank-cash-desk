package com.ratimid.fibank_cash_desk.repository;

import com.ratimid.fibank_cash_desk.entity.Balance;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    @Query("SELECT b FROM Balance b LEFT JOIN FETCH b.balanceInventories JOIN b.cashier ca WHERE b.cashier.id = :cashierId")
    List<Balance> findByCashierId(Long cashierId);

    @Query("SELECT b FROM Balance b " +
            "LEFT JOIN FETCH b.balanceInventories bi " +
            "JOIN b.currency c " +
            "WHERE b.cashier.id = :cashierId AND c.currencyCode = :currencyCode")
    Optional<Balance> findByCashierIdAndCurrencyCode(
            @Param("cashierId") Long cashierId,
            @Param("currencyCode") String currencyCode);
}
