package com.epam.jmp.service.api;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

public interface Service {

    int PAYABLE_AGE = 18;

    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);
    List<User> getAllUsers();

    default double getAverageUsersAge() {
        return getAllUsers().stream()
                .map(User::birthday)
                .map(birthday -> Period.between(birthday, LocalDate.now()))
                .map(Period::getYears)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new IllegalStateException("There is no any users!"));
    }

    static boolean isPayableUser(User user) {
        return Period.between(user.birthday(), LocalDate.now()).getYears() >= PAYABLE_AGE;
    }
}
