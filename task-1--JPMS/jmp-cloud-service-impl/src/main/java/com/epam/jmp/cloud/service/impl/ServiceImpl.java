package com.epam.jmp.cloud.service.impl;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;
import com.epam.jmp.service.api.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ServiceImpl implements Service {

    private final Map<User, List<Subscription>> userListMap= new HashMap<>();

    @Override
    public void subscribe(BankCard bankCard) {
        User user = bankCard.getUser();
        String number = bankCard.getNumber();
        Subscription subscription = new Subscription(number, LocalDate.now());
        userListMap.computeIfAbsent(user, u -> new ArrayList<>()).add(subscription);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        return userListMap.values().stream()
                .flatMap(Collection::stream)
                .filter(subscription -> subscription.bankcard().equals(cardNumber))
                .findAny();

    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userListMap.keySet());
    }
}
