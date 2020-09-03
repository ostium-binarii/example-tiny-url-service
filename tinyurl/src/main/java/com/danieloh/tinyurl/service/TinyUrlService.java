package com.danieloh.tinyurl.service;

import com.danieloh.tinyurl.dao.AppRepository;
import com.danieloh.tinyurl.exception.MalformedUrlException;
import com.danieloh.tinyurl.exception.TinyUrlIdNotFoundException;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("tinyUrlService")
public class TinyUrlService implements AppService {
    private final AppRepository repository;
    private final UrlValidator urlValidator;

    @Autowired
    public TinyUrlService(final AppRepository inMemoryUrlRepository) {
        this.repository = inMemoryUrlRepository;
        urlValidator = new UrlValidator();
    }

    public String generateTinyUrl(final String originalUrl) {
        if (!urlValidator.isValid(originalUrl)) {
            throw new MalformedUrlException("Given URL input \"" + originalUrl + "\" is not in valid format!");
        }

        final String tinyUrlId = repository.fetchTinyUrlId(originalUrl);
        if (tinyUrlId != null) {
            return tinyUrlId;
        }

        return repository.createTinyUrlId(originalUrl);
    }

    public String getOriginalUrl(final String tinyUrlId) {
        final String originalUrl = repository.fetchOriginalUrl(tinyUrlId);

        if (originalUrl == null) {
            throw new TinyUrlIdNotFoundException("Could not locate original url entry for tiny url id : \"" + tinyUrlId + "\"");
        }

        return originalUrl;
    }
}
