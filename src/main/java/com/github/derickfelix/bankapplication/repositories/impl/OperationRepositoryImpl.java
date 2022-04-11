/*
 * The MIT License
 *
 * Copyright 2019 Derick Felix.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.derickfelix.bankapplication.repositories.impl;

import com.github.derickfelix.bankapplication.database.BankAppTemplate;
import com.github.derickfelix.bankapplication.database.RowMapper;
import com.github.derickfelix.bankapplication.models.Operation;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.github.derickfelix.bankapplication.repositories.OperationRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OperationRepositoryImpl implements OperationRepository {

    private final BankAppTemplate template;
    private static OperationRepositoryImpl operationalRepoInstance = null;

    private OperationRepositoryImpl()
    {
        this.template = new BankAppTemplate();
    }

    public static OperationRepositoryImpl getLogInstance() {
        if (operationalRepoInstance == null) {
            operationalRepoInstance = new OperationRepositoryImpl();
        }
        return operationalRepoInstance;
    }

    @Override
    public List<Operation> findAllWithdraws()
    {
        String sql = "select * from withdraws";

        return template.queryForList(sql, null, new OperationMapper(Operation.Type.WITHDRAW));
    }

    @Override
    public List<Operation> findAllDeposits()
    {
        String sql = "select * from deposits";

        return template.queryForList(sql, null, new OperationMapper(Operation.Type.DEPOSIT));
    }
    
    @Override
    public List<Operation> findAllByAccountNumber(String accountNumber)
    {
        String withdrawSql = "select * from withdraws where account_number = :account_number";
        String depositSql = "select * from deposits where account_number = :account_number";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);

        List<Operation> withdraws = template.queryForList(withdrawSql, params, new OperationMapper(Operation.Type.WITHDRAW));
        List<Operation> deposits = template.queryForList(depositSql, params, new OperationMapper(Operation.Type.DEPOSIT));

        List<Operation> operations = new ArrayList<>(withdraws.size() + deposits.size());
        operations.addAll(withdraws);
        operations.addAll(deposits);

        Collections.sort(operations, (a, b) -> {
            return a.getCreatedAt().compareTo(b.getCreatedAt());
        });

        return operations;
    }

    @Override
    public List<Operation> findAllDepositsByAccountNumber(String accountNumber)
    {
        String sql = "select * from deposits where account_number = :account_number";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);

        return template.queryForList(sql, params, new OperationMapper(Operation.Type.DEPOSIT));
    }

    @Override
    public List<Operation> findAllWithdrawsByAccountNumber(String accountNumber)
    {
        String sql = "select * from withdraws where account_number = :account_number";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);

        return template.queryForList(sql, params, new OperationMapper(Operation.Type.WITHDRAW));
    }
    
    @Override
    public void deposit(String accountNumber, double amount)
    {
        String sql = "insert into deposits (created_at, account_number, amount) values (:created_at, :account_number, :amount)";
        Map<String, Object> params = new HashMap<>();
        params.put("created_at", LocalDateTime.now());
        params.put("account_number", accountNumber);
        params.put("amount", amount);

        template.update(sql, params);
    }

    @Override
    public void withdraw(String accountNumber, double amount)
    {
        String sql = "insert into withdraws (created_at, account_number, amount) values (:created_at, :account_number, :amount)";
        Map<String, Object> params = new HashMap<>();
        params.put("created_at", LocalDateTime.now());
        params.put("account_number", accountNumber);
        params.put("amount", amount);

        template.update(sql, params);
    }

    @Override
    public Optional<Double> currentBalance(String accountNumber)
    {
        String sql = "select "
                + "IFNULL((select sum(amount) from deposits where account_number = :account_number), 0) "
                + " - "
                + "IFNULL((select sum(amount) from withdraws where account_number = :account_number), 0)"
                + "as balance";
        
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);

        return template.queryForObject(sql, params, new BalanceMapper());
    }
    
    public class OperationMapper implements RowMapper<Operation> {

        private final Operation.Type type;
        
        public OperationMapper(Operation.Type type)
        {
            this.type = type;
        }
        
        @Override
        public Operation mapRow(ResultSet rs) throws SQLException
        {
            Operation operation = new Operation();
            operation.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            operation.setAccountNumber(rs.getString("account_number"));
            operation.setAmount(type == Operation.Type.WITHDRAW ? -rs.getDouble("amount") : rs.getDouble("amount"));
            operation.setType(type);
            
            return operation;
        }

    }

    public class BalanceMapper implements RowMapper<Double> {

        @Override
        public Double mapRow(ResultSet rs) throws SQLException
        {
            return rs.getDouble("balance");
        }

    }
}
