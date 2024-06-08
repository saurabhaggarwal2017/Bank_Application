package com.syc.finance.v1.bharat.Bank_Application.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    private String userId;
    @Column(nullable = false)
    private String accountHolderName;
    @Column(nullable = false,unique = true,length = 10)
    private String contactPhoneNumber;
    private String contactEmail;
    private String gender;
    private String address;
    private String pinCodeNumber;
    private String county;
    private String state;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Account> accountList = new ArrayList<>();
}
