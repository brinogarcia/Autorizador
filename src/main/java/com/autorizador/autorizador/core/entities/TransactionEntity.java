package com.autorizador.autorizador.core.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "type")
    private String type;
    @Column(name = "value")
    private BigDecimal value;
    @Column(name = "status")
    private String status;
    @Column(name = "currency")
    private String currency;
    @Column(name = "transaction_id")
    private String transactionId;

    public TransactionEntity() {
    }

    public TransactionEntity(Long id, String uuid, String type, BigDecimal value, String status, String currency, String transactionId) {
        this.uuid = uuid;
        this.type = type;
        this.value = value;
        this.status = status;
        this.currency = currency;
        this.transactionId = transactionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
