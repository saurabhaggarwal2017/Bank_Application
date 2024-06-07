package com.syc.finance.v1.bharat.Bank_Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "accountTable")
public class Account {
    @Id
    private String accountId;
    @Column(unique = true, updatable = false)
    private String accountNumber;
    @Column(nullable = false)
    private String ifscCode;
    @Column(nullable = false)
    private String accountType;
    private String bankName;
    private String bankBranchName;
    private String routingNumber;
    private String bankPinCode;
    private String isHaveUpiId;
    private int accountBalance;
    private String status; // bank active or not.
    private LocalDate localDateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UpiInformation> upiInformationList;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private NetBanking netBanking;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TransactionHistoryDetails> transactionHistoryDetailsList;


}
