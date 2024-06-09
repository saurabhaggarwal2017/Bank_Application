package com.syc.finance.v1.bharat.Bank_Application.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Random;

public class AccountDetailsGenerator {
    // total number of branches 4.
    public static final String[] branchCode = new String[]{"11001", "1102", "1103", "1104"};
    public static final String[] branchName = new String[]{"JYOTI NAGAR DEL DL", "NAND NAGARI UP", "SHAHDARA DEL DL", "DURGAPURI DEL DL"};

    public static String generateAccountNumber() {
        // 12 digit bank account number.
        // new Random().nextLong(10000000000l) thats generate maximum 99999999999 11 digit and
        //  100000000000l thats are a 12 digit number in which 11 zero. so every bank account no. start with '1'
        long accountNumber = new Random().nextLong(10000000000l) + 100000000000l;
        return String.valueOf(accountNumber);
    }

    public static String generateIFSCNumber() {
        // 11 digit ifsc code
//        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        StringBuilder starting = new StringBuilder();
//
//        for (int i = 1; i <= 4; i++) {
//            char ch = character.charAt(new Random().nextInt(26));
//            starting.append(ch);
//        }
        int ending = new Random().nextInt(9000000) + 1000000;
        return "BOBL" + String.valueOf(ending);
    }

}

