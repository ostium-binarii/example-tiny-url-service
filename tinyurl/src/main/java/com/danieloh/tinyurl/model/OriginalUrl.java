package com.danieloh.tinyurl.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;


@NoArgsConstructor
@Data
@EqualsAndHashCode
public class OriginalUrl {
    private String originalUrl;
}
