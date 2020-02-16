package hashtable.encode_and_decode_tiny_url_535;

/*
535. Encode and Decode TinyURL
https://leetcode.com/problems/encode-and-decode-tinyurl/#/description

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service.
There is no restriction on how your encode/decode algorithm should
work. You just need to ensure that a URL can be encoded to a
tiny URL and the tiny URL can be decoded to the original URL.
* */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
    private int counter = 0;
    private HashMap<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode1(String longUrl) {
        counter++;
        map.put(String.valueOf(counter), longUrl);
        return String.valueOf(counter);
    }

    // Decodes a shortened URL to its original URL.
    public String decode1(String shortUrl) {
        if (!map.containsKey(shortUrl)) return "";
        return map.get(shortUrl);
    }


    // SnapshotArray
    // Great solution and explanation
    //https://discuss.leetcode.com/topic/81637/two-solutions-and-thoughts
    // https://discuss.leetcode.com/topic/81637/two-solutions-and-thoughts/3
    private Map<String, String> longToShort = new HashMap<>();
    private Map<String, String> shortToLong = new HashMap<>();
    private Random rnd = new Random();

    // Encodes a URL to a shortened URL.
    String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) return longToShort.get(longUrl);
        String key = generateKey();
        longToShort.put(longUrl, key);
        shortToLong.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    String decode(String shortUrl) {
        if (!shortToLong.containsKey(shortUrl)) return "";
        return shortToLong.get(shortUrl);
    }

    private String generateKey() {
        StringBuilder sb = new StringBuilder();
        int KEY_LEN = 6;
        for (int i = 0; i < KEY_LEN; i++) {
            String source = "ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuwxyz0123456789";
            int nextCharIndex = rnd.nextInt(source.length());
            sb.append(source.charAt(nextCharIndex));
        }
        String key = sb.toString();
        return shortToLong.containsKey(key) ? generateKey() : key;
    }
}