package com.seemee.model;

import com.seemee.dto.Address;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class User {
    private String userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private List<Address> address;
    private List<String> role;
    private boolean status;
    private Date createdDate;
    private Date updatedDate;
    private Date lastLoginDate;
    private String lastLoginIp;
    private Date loginBlockedDate;
    private String loginBlockedIp;
    private String loginBlockedReason;
    private List<String> subscription;
    private List<BankAccount> bankAccount;
    private List<CreditCard> creditCard;
    private List<Upi> upi;

    // Getters and Setters
    // ...
}
@Data
class BankAccount {
    private String bankName;
    private String accountNumber;
    private String accountType;
    private String routingNumber;
}
@Data
class CreditCard {
    private String cardNumber;
    private String cardType;
    private Date expirationDate;
    private String status;
    private Date createdDate;
    private Date updatedDate;

    // Getters and Setters
    // ...
}

@Data
class Upi {
    private String upiId;
    private String status;
    private Date createdDate;
    private Date updatedDate;

    // Getters and Setters
    // ...
}