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
import com.github.derickfelix.bankapplication.models.Deposit;
import com.github.derickfelix.bankapplication.models.Withdraw;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.github.derickfelix.bankapplication.repositories.OperationRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationRepositoryImpl implements OperationRepository {

    private final BankAppTemplate template;
    
    public OperationRepositoryImpl()
    {
        this.template = new BankAppTemplate();
    }

    @Override
    public List<Withdraw> withdraws()
    {
        String sql = "select * from withdraws";

        return template.queryForList(sql, null, new DepositMapper());
    }

    @Override
    public List<Deposit> deposits()
    {
        String sql = "select * from deposits";

        return template.queryForList(sql, null, new DepositMapper());
    }

    @Override
    public List<Deposit> deposits(String accountNumber)
    {
        String sql = "select * from deposits where account_number = :account_number";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);
        
        return template.queryForList(sql, params, new DepositMapper());
    }

    @Override
    public List<Withdraw> withdraws(String accountNumber)
    {
        String sql = "select * from withdraws where account_number = :account_number";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);

        return template.queryForList(sql, params, new WithdrawMapper());
    }

    @Override
    public void deposit(String accountNumber, double amount)
    {
        String sql = "insert into deposits (account_number, deposit_amount) values (:account_number, :deposit_amount)";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);
        params.put("deposit_amount", amount);
        
        template.update(sql, params);
    }

    @Override
    public void withdraw(String accountNumber, double amount)
    {
        String sql = "insert into withdraws (account_number, withdraw_amount) values (:account_number, :deposit_amount)";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);
        params.put("withdraw_amount", amount);

        template.update(sql, params);
    }
   
    public class WithdrawMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs) throws SQLException
        {
            return new Withdraw(rs.getString("account_number"), rs.getDouble("withdraw_amount"), rs.getDate("created_at"));
        }

    }
    
    public class DepositMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs) throws SQLException
        {
            return new Deposit(rs.getString("account_number"), rs.getDouble("deposit_amount"), rs.getDate("created_at"));
        }

    }
}
