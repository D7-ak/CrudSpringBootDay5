package com.example.bank.BankClass;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customers {
    private String id;
    private String userName;
    private int balance;
}
