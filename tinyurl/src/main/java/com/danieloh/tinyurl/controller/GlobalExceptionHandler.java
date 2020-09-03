package com.danieloh.tinyurl.controller;

import com.danieloh.tinyurl.exception.DuplicateOriginalUrlException;
import com.danieloh.tinyurl.exception.DuplicateTinyUrlIdException;
import com.danieloh.tinyurl.exception.MalformedUrlException;
import com.danieloh.tinyurl.exception.NullOrBlankUrlException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<String> handleException(UnrecognizedPropertyException e) {
        // in real life we'd also log more things like request source, etc.
        log.info("Unexpected JSON property.", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Your request may have an invalid field.");
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<String> handleException(JsonParseException e) {
        log.info("Unexpected JSON format.", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Your request may not have been formatted correctly.");
    }

    @ExceptionHandler(NullOrBlankUrlException.class)
    public ResponseEntity<String> handleException(NullOrBlankUrlException e) {
        log.info("Missing URL data in request.", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(MalformedUrlException.class)
    public ResponseEntity<String> handleException(MalformedUrlException e) {
        log.info("URL data in request was of invalid format.", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(DuplicateOriginalUrlException.class)
    public ResponseEntity<String> handleException(DuplicateOriginalUrlException e) {
        log.info("{}", e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("A data processing error occurred, try again later.");
    }

    @ExceptionHandler(DuplicateTinyUrlIdException.class)
    public ResponseEntity<String> handleException(DuplicateTinyUrlIdException e) {
        log.info("{}", e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("A data processing error occurred, try again later.");
    }

}
