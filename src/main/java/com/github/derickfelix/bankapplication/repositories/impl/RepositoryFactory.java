package com.github.derickfelix.bankapplication.repositories.impl;

import com.github.derickfelix.bankapplication.repositories.BaseRepository;

public class RepositoryFactory {
    public BaseRepository getInstance(String repo) {
        if(repo.equalsIgnoreCase("user")) {
            return new UserRepositoryImpl();
        } else if (repo.equalsIgnoreCase("customer")) {
            return new CustomerRepositoryImpl();
        }
        return null;
    }
}
