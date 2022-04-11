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
import com.github.derickfelix.bankapplication.models.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.github.derickfelix.bankapplication.repositories.CustomerRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.h2.util.StringUtils;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final BankAppTemplate template;
    private static CustomerRepositoryImpl custRepoInstance = null;
    private CustomerRepositoryImpl()
    {
        this.template = new BankAppTemplate();
    }

    public static CustomerRepositoryImpl getLogInstance() {
        if(custRepoInstance == null) {
            custRepoInstance = new CustomerRepositoryImpl();
        }
        return custRepoInstance;

    }

    @Override
    public List<Customer> findAll()
    {
        String sql = "select * from customers";
        
        return template.queryForList(sql, null, new CustomerMapper());
    }

    @Override
    public Optional<Customer> find(Long id)
    {
        String sql = "select * from customers where id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        
        return template.queryForObject(sql, params, new CustomerMapper());
    }

    @Override
    public void save(Customer model)
    {
        String sql;
        Map<String, Object> params = new HashMap<>();
        
        if (model.getId() == null) {
            sql = "insert into customers (name, address, account_number, account_type, password) "
                    + "values (:name, :address, :account_number, :account_type, HASH('SHA256', :password))";

            params.put("password", model.getPassword());
        } else {
            sql = "update customers set name = :name, address = :address, "
                    + "account_number = :account_number, account_type = :account_type "
                    + "where id = :id";

            params.put("id", model.getId());            
        }
        
        params.put("name", model.getName());
        params.put("address", model.getAddress());
        params.put("account_number", model.getAccountNumber());
        params.put("account_type", model.getAccountType());
        
        template.update(sql, params);
    }

    @Override
    public Optional<Customer> deleteById(Long id)
    {
        Optional<Customer> optional = find(id);
        
        optional.ifPresent(customer -> {
            String sql = "delete from customers where id = :id";
            Map<String, Object> params = new HashMap<>();
            params.put("id", customer.getId());

            template.update(sql, params);
        });
        
        return optional;
    }

    @Override
    public List<Customer> search(String term)
    {
        String sql = "select * from customers where id = :code or (upper(name) like :term or upper(address) like :term or upper(account_number) like :term or upper(account_type) like :term)";
        Map<String, Object> params = new HashMap<>();
        params.put("code", StringUtils.isNumber(term) ? term : -1);
        params.put("term", "%" + term.toUpperCase() + "%");

        return template.queryForList(sql, params, new CustomerMapper());
    }
    
    @Override
    public Optional<Customer> findByAccountNumber(String accountNumber)
    {
        String sql = "select * from customers where account_number = :account_number";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);

        return template.queryForObject(sql, params, new CustomerMapper());
    }

    @Override
    public Optional<Customer> findByAccountNumberAndPassword(String accountNumber, String password)
    {
        String sql = "select * from customers where account_number = :account_number and password = HASH('SHA256', :password)";
        Map<String, Object> params = new HashMap<>();
        params.put("account_number", accountNumber);
        params.put("password", password);

        return template.queryForObject(sql, params, new CustomerMapper());
    }
    
    public class CustomerMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs) throws SQLException
        {
            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setName(rs.getString("name"));
            customer.setAddress(rs.getString("address"));
            customer.setAccountNumber(rs.getString("account_number"));
            customer.setAccountType(rs.getString("account_type"));
            customer.setPassword(rs.getString("password"));

            return customer;
        }
        
    }
}
