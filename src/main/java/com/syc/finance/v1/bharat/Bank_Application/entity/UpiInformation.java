package com.syc.finance.v1.bharat.Bank_Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "UpiInfo")
public class UpiInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String upiId;
    private String upiPin;
    private String contactNumber;
    private String status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
