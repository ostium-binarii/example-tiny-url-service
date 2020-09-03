package com.danieloh.tinyurl.controller;

import com.danieloh.tinyurl.exception.NullOrBlankUrlException;
import com.danieloh.tinyurl.model.OriginalUrl;
import com.danieloh.tinyurl.model.TinyUrl;
import com.danieloh.tinyurl.service.AppService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/generate")
@Slf4j
public class GenerateUrlController {
    private static final String URL_PREFIX = "http://localhost:8080/";
    private final AppService service;
    private final ObjectMapper mapper;

    @Autowired
    public GenerateUrlController(final AppService tinyUrlService) {
        service = tinyUrlService;
        mapper = new ObjectMapper();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TinyUrl> generateTinyUrl(final @RequestBody String body) throws JsonProcessingException {
        final String originalUrl = mapper.readValue(body, OriginalUrl.class).getOriginalUrl();

        if (StringUtils.isBlank(originalUrl)) {
            // in real life we'd also log more things like request source, etc.
            log.info("Request body with originalUrl String was null or blank String.");
            throw new NullOrBlankUrlException("Given URL is empty or blank.");
        }

        final String tinyUrl = URL_PREFIX + service.generateTinyUrl(originalUrl);

        return ResponseEntity.ok().body(new TinyUrl(tinyUrl));
    }

}
