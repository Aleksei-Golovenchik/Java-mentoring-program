package com.epam.jmp.colud.bank.impl;

import com.epam.jmp.bank.api.Bank;
import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.CreditBankCard;
import com.epam.jmp.dto.DebitBankCard;
import com.epam.jmp.dto.User;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class BankImpl implements Bank {

    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return Optional.ofNullable(bankCardType)
                .filter(cardType -> Objects.nonNull(user))
                .map(cardType -> switch (cardType) {
                    case CREDIT -> new CreditBankCard(UUID.randomUUID().toString(), user);
                    case DEBIT -> new DebitBankCard(UUID.randomUUID().toString(), user);
                })
                .orElseThrow(() -> new IllegalArgumentException("User and card type can not be null!"));
    }
}
