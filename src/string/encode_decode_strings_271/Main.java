package string.encode_decode_strings_271;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Codec s = new Codec();
        List<String> source = new ArrayList<>();
        source.add("abc");
        source.add("def");
        String result = s.encode(source);
        System.out.println("result = " + result);
        source = s.decode(result);
        System.out.print(source);
    }
}
