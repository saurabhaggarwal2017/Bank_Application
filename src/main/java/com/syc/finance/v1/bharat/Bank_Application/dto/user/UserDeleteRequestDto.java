package com.syc.finance.v1.bharat.Bank_Application.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.usertype.BaseUserTypeSupport;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDeleteRequestDto {
    private String accountNumber;
    private String ifscCode;
    private String contactPhoneNumber;
    private String accountHolderName;
}
