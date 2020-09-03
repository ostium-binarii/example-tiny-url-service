package com.danieloh.tinyurl.controller;

import com.danieloh.tinyurl.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class RedirectUrlController {
    private final AppService service;

    @Autowired
    public RedirectUrlController(final AppService tinyUrlService) {
        service = tinyUrlService;
    }

    @GetMapping(value = "/{tinyUrlId}")
    public ModelAndView generateTinyUrl(final @PathVariable String tinyUrlId) {
        final String originalUrl = service.getOriginalUrl(tinyUrlId);
        try {
            return new ModelAndView("redirect:" + originalUrl);
        } finally {
            log.info("Redirected user from Tiny URL ID \"" + tinyUrlId + "\" to \"" + originalUrl + "\" ");
        }
    }

}
