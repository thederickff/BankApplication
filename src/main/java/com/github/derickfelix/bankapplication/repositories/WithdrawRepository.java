package com.github.derickfelix.bankapplication.repositories;

import com.github.derickfelix.bankapplication.models.Operation;
import java.util.List;
import java.util.Optional;

public interface WithdrawRepository{
    List<Operation> findAllWithdrawsByAccountNumber(String accountNumber);
    void withdraw(String accountNumber, double amount);
    List<Operation> findAllWithdraws();
}