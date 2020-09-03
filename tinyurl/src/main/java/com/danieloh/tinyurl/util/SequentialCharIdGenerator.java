package com.danieloh.tinyurl.util;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;


@Service("sequentialCharIdGenerator")
@Slf4j
public class SequentialCharIdGenerator implements IdGenerator {
    private static final Set<Character> POSSIBLE_CHARACTERS = ImmutableSet.of(
        'A', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q', 'R','S','T','U','V','W','X',
        'Y','Z','a','b','c','d','e','f','g','h','i','j', 'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y',
        'z','0','1','2','3','4','5','6','7','8','9');
    private static final int ID_TOO_LONG_THRESHOLD = 8;
    private static int id_length = 1;
    private static Iterator<Set<Character>> idIterator = Sets.combinations(POSSIBLE_CHARACTERS, id_length).iterator();

    public synchronized String generateId() {
        if (!idIterator.hasNext()) {
            id_length++;
            checkIfIdTooLong();
            idIterator = Sets.combinations(POSSIBLE_CHARACTERS, id_length).iterator();
        }

        return idIterator.next()
                         .stream()
                         .map(String::valueOf)
                         .collect(Collectors.joining());
    }

    private static void checkIfIdTooLong() {
        if (id_length > ID_TOO_LONG_THRESHOLD) {
            log.warn("The tiny url ID is now over {} characters long!", ID_TOO_LONG_THRESHOLD);
        }
    }

}
