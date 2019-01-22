package backtracking.binary_watch_401;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> strings = s.readBinaryWatch(2);
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }
}


