package com.ratimid.fibank_cash_desk.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
public class Denomination {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(
            name = "sequence_generator",
            sequenceName = "denomination_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "nominal_value")
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

    @OneToMany(mappedBy = "denomination", cascade = CascadeType.ALL)
    private Set<BalanceInventory> balanceInventories;

    @Column(
            name = "created_date",
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime createdDate;

    @Column(
            name = "last_modified_date",
            insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP"
    )
    private LocalDateTime lastModifiedDate;

    public Denomination() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Set<BalanceInventory> getBalanceInventories() {
        return balanceInventories;
    }

    public void setBalanceInventories(Set<BalanceInventory> balanceInventories) {
        this.balanceInventories = balanceInventories;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Denomination that = (Denomination) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
