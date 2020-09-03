package com.danieloh.tinyurl.dao;

import com.danieloh.tinyurl.exception.DuplicateOriginalUrlException;
import com.danieloh.tinyurl.exception.DuplicateTinyUrlIdException;
import com.danieloh.tinyurl.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository("inMemoryUrlRepository")
public class InMemoryUrlRepository implements AppRepository {
    // while for the sake of time the repo is an in-memory one, a real solution would look something like a DynamoDB
    // table with a HashKey of TinyUrlId and a GSI with a HashKey of OriginalUrl. There would also need to be created
    // datetime and other elements not necessarily applicable in this temporary in-memory implementation in the data
    // model.
    private static Map<String, String> tinyUrlIdsByOriginalUrl;
    private static Map<String, String> originalUrlsByTinyUrlId;
    private IdGenerator idGenerator;

    @Autowired
    public InMemoryUrlRepository(IdGenerator sequentialCharIdGenerator) {
        idGenerator = sequentialCharIdGenerator;
        tinyUrlIdsByOriginalUrl = new HashMap<>();
        originalUrlsByTinyUrlId = new HashMap<>();
    }

    @Override
    public String fetchTinyUrlId(final String originalUrl) {
        return tinyUrlIdsByOriginalUrl.get(originalUrl);
    }

    @Override
    public String fetchOriginalUrl(final String tinyUrlId) {
        return originalUrlsByTinyUrlId.get(tinyUrlId);
    }

    @Override
    public String createTinyUrlId(final String originalUrl) {
        String tinyUrlId = fetchTinyUrlId(originalUrl);

        if (tinyUrlId != null) {
            throw new DuplicateOriginalUrlException(
                "Attempted to create new tiny url id for existing original Url: \"" +
                originalUrl + "\"" + " associated to existing tiny url id: \"" + tinyUrlId + "\""
            );
        }

        tinyUrlId = idGenerator.generateId();

        if (originalUrlsByTinyUrlId.containsKey(tinyUrlId)) {
            throw new DuplicateTinyUrlIdException(
                "Attempted to create tiny url id \"" + tinyUrlId + "\" but it is already associated " +
                " associated to existing original url: \"" + fetchOriginalUrl(tinyUrlId) + "\""
            );
        }

        tinyUrlIdsByOriginalUrl.put(originalUrl, tinyUrlId);
        originalUrlsByTinyUrlId.put(tinyUrlId, originalUrl);

        return tinyUrlId;
    }

}
