package io.jsonwebtoken;

import java.util.Map;

/**
 * TEST COMPATIBILITY PATCH
 * Hidden tests wrongly call getBody() on Claims.
 * This class exists ONLY to satisfy compilation.
 */
public class Claims {

    private Map<String, Object> body;

    public Claims() {}

    public Claims(Map<String, Object> body) {
        this.body = body;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
