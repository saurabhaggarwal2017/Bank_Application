package com.syc.finance.v1.bharat.Bank_Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "netBankingInfo")
public class NetBanking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String netBankingId;
    private String password;
    private LocalDate localDateTime;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
