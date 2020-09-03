package com.danieloh.tinyurl.dao;


public interface AppRepository {
    String fetchTinyUrlId(String originalUrl);

    String fetchOriginalUrl(String tinyUrlId);

    String createTinyUrlId(String originalUrl);
}
