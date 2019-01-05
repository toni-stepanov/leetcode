package hashtable.encode_and_decode_tiny_url_535;

public class Main {
    public static void main(String[] args) {
        Codec s = new Codec();
        String result = s.decode(s.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.print(result);
    }
}


