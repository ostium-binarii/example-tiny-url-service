package com.danieloh.tinyurl.service;

import com.danieloh.tinyurl.dao.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tinyUrlService")
public class TinyUrlService implements AppService {
    private AppRepository repository;

    @Autowired
    public TinyUrlService(final AppRepository inMemoryUrlRepository) {
        this.repository = inMemoryUrlRepository;
    }

    public void generateUrl() {
        repository.getUrl();
    }
}
