package array.pascal_triangle_118;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution tr = new Solution();
        List<List<Integer>> result = tr.generate(10);
        System.out.println(result);
        List<List<Integer>> result2 = tr.generate(22);
        System.out.print(result2);
    }
}

