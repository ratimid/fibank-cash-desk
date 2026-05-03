package com.ratimid.fibank_cash_desk.config.security;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "api_key", indexes = {
        @Index(name = "idx_client", columnList = "client")
})
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(
            name = "sequence_generator",
            sequenceName = "api_key_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(unique = true, nullable = false)
    private String hashedKey;

    private String client;

    private boolean active;

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


    public ApiKey() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
}
