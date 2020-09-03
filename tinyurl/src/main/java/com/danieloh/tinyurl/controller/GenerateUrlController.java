package com.danieloh.tinyurl.controller;

import com.danieloh.tinyurl.model.TinyUrl;
import com.danieloh.tinyurl.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GenerateUrlController {
    private AppService service;

    @Autowired
    public GenerateUrlController(final AppService tinyUrlService) {
        service = tinyUrlService;
    }

    @RequestMapping("/api/generate")
    public ResponseEntity<TinyUrl> generateTinyUrl(final @RequestBody String originalUrl) {
        service.generateUrl();
        return null;
    }

}
