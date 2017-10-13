/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

import com.bankapplication.model.Customer;
import com.bankapplication.respository.impl.CustomerRepository;
import java.util.ArrayList;

/**
 * @name CustomerController
 * @author derickfelix
 * @date Sep 26, 2017
 */
public class CustomerController {

    private static CustomerController customerCtrl;
    private CustomerRepository customerRepository;

    private CustomerController() {
        this.customerRepository = new CustomerRepository();
    }

    public void store(Customer customer) {
        customerRepository.store(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customerRepository.all();
    }

    public Customer searchCustomer(int accountNumber) {
        return customerRepository.find(accountNumber);
    }

    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    public void destroy(Customer customer) {
        customerRepository.destroy(customer);
    }

    public static CustomerController getInstance() {
        if (customerCtrl == null) {
            customerCtrl = new CustomerController();
        }
        return customerCtrl;
    }
}
