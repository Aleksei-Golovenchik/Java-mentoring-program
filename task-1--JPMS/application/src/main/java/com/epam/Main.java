package com.epam;

import com.epam.jmp.bank.api.Bank;
import com.epam.jmp.cloud.service.impl.ServiceImpl;
import com.epam.jmp.colud.bank.impl.BankImpl;
import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.User;
import com.epam.jmp.service.api.Service;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        User user = new User("Alex", "Swarowsky", LocalDate.of(1980, Month.APRIL, 1));
        Bank bank = new BankImpl();
        BankCard bankCard1 = bank.createBankCard(user, BankCardType.CREDIT);
        BankCard bankCard2 = bank.createBankCard(user, BankCardType.DEBIT);
        Service service = new ServiceImpl();
        service.subscribe(bankCard1);
        service.subscribe(bankCard2);
        System.out.println(service.getAllUsers());
        System.out.println(service.getSubscriptionByBankCardNumber(bankCard1.getNumber()).orElseThrow());


    }
}