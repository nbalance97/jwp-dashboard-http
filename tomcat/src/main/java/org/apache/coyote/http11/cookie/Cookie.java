package org.apache.coyote.http11.cookie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Cookie {
    private final Map<String, String> cookies;

    public Cookie() {
        this.cookies = new ConcurrentHashMap<>();
    }

    public boolean hasCookie(String cookieName) {
        return cookies.containsKey(cookieName);
    }

    public void setCookie(String cookieKey, String cookieValue) {
        cookies.put(cookieKey, cookieValue);
    }

    public String getCookie(String cookieKey) {
        return cookies.get(cookieKey);
    }

    public boolean isEmpty() {
        return cookies.isEmpty();
    }

    public String generateCookieEntries() {
        List<String> cookieEntries = cookies.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.toList());

        return String.join("; ", cookieEntries);
    }
}
