package com.syc.finance.v1.bharat.Bank_Application.services.AccountService;

import static com.syc.finance.v1.bharat.Bank_Application.constant.AccountDetailsConstant.*;

import com.syc.finance.v1.bharat.Bank_Application.constant.AccountDetailsConstant;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserRequestDto;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserResponseDto;
import com.syc.finance.v1.bharat.Bank_Application.entity.Account;
import com.syc.finance.v1.bharat.Bank_Application.entity.User;
import com.syc.finance.v1.bharat.Bank_Application.repository.AccountRepo;
import com.syc.finance.v1.bharat.Bank_Application.repository.UserRepo;
import com.syc.finance.v1.bharat.Bank_Application.utils.AccountDetailsGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final UserRepo userRepo;
    private final ModelMapper mapper;

    @Override
    public UserResponseDto createAccount(UserRequestDto userRequestDto) {
        log.info("New Account creating..");
        // generate user id.
        String userId = UUID.randomUUID().toString();
        // check user already there or not.
        Optional<User> user = userRepo.findByContactPhoneNumberAndContactEmail(userRequestDto.getContactPhoneNumber(), userRequestDto.getContactEmail());
        if (user.isPresent()) {
            //TODO:create exception for already present user.
            throw new RuntimeException("User already Present!!");
        }
        // make entity
        User newUser = mapper.map(userRequestDto, User.class);
        // set user id in entity
        newUser.setUserId(userId);
        log.info("User data while using mapper dto -> user {}", newUser);

        // mapping validator.........
        //mapper.validate();

        // generate random number for assigning branch code and branch for a user.
        Random random = new Random();
        int randomNumberForAssignBranch = random.nextInt(AccountDetailsGenerator.branchCode.length);
        // create new account;
        Account newAccount = Account.builder()
                .accountId(UUID.randomUUID().toString())
                .accountNumber(AccountDetailsGenerator.generateAccountNumber())
                .ifscCode(AccountDetailsGenerator.generateIFSCNumber())
                .accountType(userRequestDto.getAccountType())
                .bankName(BANK_VI_NAME)
                .branchCode(AccountDetailsGenerator.branchCode[randomNumberForAssignBranch])
                .bankBranchName(AccountDetailsGenerator.branchName[randomNumberForAssignBranch])
                // TODO : MAKE ONE API FOR SETTING BANK PIN CODE.
                .bankPinCode("")
                .isHaveUpiId(false)
                .accountBalance(0)
                .status(BANK_VI_ACCOUNT_BALANCE_STATUS)
                .localDateTime(LocalDate.now())
                .user(newUser)
                .build();

        // add account in user list
        List<Account> accountList = newUser.getAccountList();
        accountList.add(newAccount);
        newUser.setAccountList(accountList);

        // save user and account in repo
        User savedNewUser = userRepo.save(newUser);
        // make response and convert to dto
        UserResponseDto response = mapper.map(savedNewUser, UserResponseDto.class);
        mapper.map(newAccount, response);

        log.info("User response dto : {}", response);
        log.info("Account successfully created...");
//        mapper.validate();
        // return dto
        return response;
    }
}
