package com.ratimid.fibank_cash_desk.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(
            name = "sequence_generator",
            sequenceName = "currency_seq",
            allocationSize = 1
    )
    private Long id;

    private String currencyCode;

    private String name;

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

    public Currency() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Currency currency = (Currency) o;
        return Objects.equals(id, currency.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
