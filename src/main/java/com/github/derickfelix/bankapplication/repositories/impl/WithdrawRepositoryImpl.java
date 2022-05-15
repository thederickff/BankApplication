package com.github.derickfelix.bankapplication.repositories.impl;

import com.github.derickfelix.bankapplication.database.BankAppTemplate;
import com.github.derickfelix.bankapplication.database.RowMapper;
import com.github.derickfelix.bankapplication.models.Operation;
import com.github.derickfelix.bankapplication.repositories.WithdrawRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WithdrawRepositoryImpl implements WithdrawRepository {
    private final BankAppTemplate template;

    public WithdrawRepositoryImpl() {
        this.template = new BankAppTemplate();
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
    public List<Operation> findAllWithdrawsByAccountNumber(String accountNumber)
    {
        String sql = "select * from withdraws where account_number = :account_number";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);

        return template.queryForList(sql, params, new WithdrawRepositoryImpl.WithdrawMapper(Operation.Type.WITHDRAW));
    }

    @Override
    public List<Operation> findAllWithdraws()
    {
        String sql = "select * from withdraws";

        return template.queryForList(sql, null, new WithdrawRepositoryImpl.WithdrawMapper(Operation.Type.WITHDRAW));
    }

    public class WithdrawMapper implements RowMapper<Operation> {

        private final Operation.Type type;

        public WithdrawMapper(Operation.Type type)
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

}
