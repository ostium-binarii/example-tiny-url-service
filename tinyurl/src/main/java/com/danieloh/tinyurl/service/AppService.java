package com.danieloh.tinyurl.service;


public interface AppService {
    String generateTinyUrl(String originalUrl);

    String getOriginalUrl(String tinyUrlId);
}
