package com.autorizador.autorizador.core.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Account")
public class AccountEntity {

    @Id
    private String id;
    @Column(name = "owner")
    private String owner;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "status")
    private String status;
    @Column(name = "amount")
    private BigDecimal amount;

    public AccountEntity() {
    }

    public AccountEntity(String id, String owner, String created_at, String status) {
        this.id = id;
        this.owner = owner;
        this.created_at = created_at;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getAmount(){
        return amount;
    }
}
