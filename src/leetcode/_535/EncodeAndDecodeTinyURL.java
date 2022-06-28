package leetcode._535;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/
 */
public class EncodeAndDecodeTinyURL {

}

public class Codec {

    public static final String urlPrefix = "https://leetcode.com/problems/";
    public static int id = 0;
    public Map<String, String> urlMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encodedUrl = urlPrefix + (id++);
        urlMap.put(encodedUrl, longUrl);
        return encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}
