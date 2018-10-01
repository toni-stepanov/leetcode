package array.triangle_120;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> first = Collections.singletonList(-1);
        List<Integer> second = Arrays.asList(2, 3);
        List<Integer> third = Arrays.asList(1, -1, -3);
        List<List<Integer>> triangle = Arrays.asList(first, second, third);

        int min = s.minimumTotal(triangle);
        System.out.print(min);
    }
}


