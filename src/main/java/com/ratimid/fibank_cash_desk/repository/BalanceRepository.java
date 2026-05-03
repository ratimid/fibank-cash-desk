package com.ratimid.fibank_cash_desk.repository;

import com.ratimid.fibank_cash_desk.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    @Query("SELECT b FROM Balance b LEFT JOIN FETCH b.balanceInventories WHERE b.cashier.id = :cashierId")
    List<Balance> findByCashierId(Long cashierId);
}
