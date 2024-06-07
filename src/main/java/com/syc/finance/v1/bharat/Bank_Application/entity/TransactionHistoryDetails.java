package com.syc.finance.v1.bharat.Bank_Application.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactionInfo")
public class TransactionHistoryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String debitOrCredit;
    @Column(nullable = false)
    private String status;
    private int amount;
    private LocalDate dateOfTransaction;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
