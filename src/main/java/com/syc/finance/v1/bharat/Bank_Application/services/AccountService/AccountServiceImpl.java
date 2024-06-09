package com.syc.finance.v1.bharat.Bank_Application.services.AccountService;

import static com.syc.finance.v1.bharat.Bank_Application.constant.AccountDetailsConstant.*;

import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserCreateRequestDto;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserCreateResponseDto;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserDetailsUpdateRequestDto;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserDetailsUpdateResponseDto;
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
    public UserCreateResponseDto createAccount(UserCreateRequestDto userCreateRequestDto) {
        log.info("New Account creating..");
        // generate user id.
        String userId = UUID.randomUUID().toString();
        // check user already there or not.
        Optional<User> user = userRepo.findByContactPhoneNumber(userCreateRequestDto.getContactPhoneNumber());
        if (user.isPresent()) {
            //TODO:create exception for already present user.
            throw new RuntimeException("User already Present!!");
        }
        // make entity
        User newUser = mapper.map(userCreateRequestDto, User.class);
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
                .accountType(userCreateRequestDto.getAccountType())
                .bankName(BANK_VI_NAME)
                .branchCode(AccountDetailsGenerator.branchCode[randomNumberForAssignBranch])
                .bankBranchName(AccountDetailsGenerator.branchName[randomNumberForAssignBranch])
                // TODO : MAKE ONE API FOR SETTING BANK PIN CODE.
                .bankPinCode("")
                .isHaveUpiId(false)
                .accountBalance(0)
                .status(BANK_VI_ACCOUNT_BALANCE_STATUS)
                .localDateTime(LocalDate.now())
                .isPhoneNumberLinked(false)
                // user set in account. imp
                .user(newUser)
                .build();

        // add account in user list
        newUser.setAccount(newAccount);
        // save user and account in repo
        User savedNewUser = userRepo.save(newUser);
        // make response and convert to dto
        UserCreateResponseDto response = mapper.map(savedNewUser, UserCreateResponseDto.class);
        // now map the rest of the property of dto.
        mapper.map(newAccount, response);

        log.info("User response dto : {}", response);
        log.info("Account successfully created...");
//        mapper.validate();
        // return dto
        return response;
    }

    @Override
    public UserDetailsUpdateResponseDto updateAccountDetails(String accountNumber, String ifscCode, UserDetailsUpdateRequestDto requestDto) {
        // find account details.
        log.info("updating user details....");
        Account account = accountRepo.findByAccountNumberAndIfscCode(accountNumber, ifscCode)
                .orElseThrow(() -> new RuntimeException("Wrong account details pass by user!!"));
        // TODO: make custom exception for account not found.

        User user = account.getUser();
        if (!user.getContactPhoneNumber().equals(requestDto.getOldContactPhoneNumber())) {
            throw new RuntimeException("Contact Number not matching!! try again.");
            // TODO: make new Custom exception.
        }
        // update details if any field is empty so set old one details.
        user.setAccountHolderName(
                requestDto.getAccountHolderName().isEmpty() ? user.getAccountHolderName() : requestDto.getAccountHolderName());

        user.setContactEmail(
                requestDto.getContactEmail().isEmpty() ? user.getContactEmail() : requestDto.getContactEmail());

        user.setGender(
                requestDto.getGender().isEmpty() ? user.getGender() : requestDto.getGender());

        user.setAddress(
                requestDto.getAddress().isEmpty() ? user.getAddress() : requestDto.getAddress());

        if (!requestDto.getContactPhoneNumber().isEmpty()) {
            // is user update number so unlinked the phone number too.
            user.setContactPhoneNumber(requestDto.getContactPhoneNumber());
            account.setPhoneNumberLinked(false);
        }

        user.setPinCodeNumber(
                requestDto.getPinCodeNumber().isEmpty() ? user.getPinCodeNumber() : requestDto.getPinCodeNumber());

        user.setState(
                requestDto.getState().isEmpty() ? user.getState() : requestDto.getState());

        account.setAccountType(
                requestDto.getAccountType().isEmpty() ? account.getAccountType() : requestDto.getAccountType());
        // save user.
        user.setAccount(account);
        User updatedUser = userRepo.save(user);

        UserDetailsUpdateResponseDto response = mapper.map(updatedUser, UserDetailsUpdateResponseDto.class);
        mapper.map(account, response);
        log.info("complete updating user details....");
        return response;
    }
}
