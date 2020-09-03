package com.danieloh.tinyurl.dao;

import org.springframework.stereotype.Repository;

@Repository("inMemoryUrlRepository")
public class InMemoryUrlRepository implements AppRepository {
    @Override
    public void getUrl() {
        System.out.println("All autowirings work.");
    }
}
