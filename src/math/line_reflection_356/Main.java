package math.line_reflection_356;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = new int[][]{
                {1,1}, {-1,1}, {100, 1}, {2,5}, {-2, 5}
        };
        boolean result = s.isReflected(points) ;
        System.out.println(result);
    }
}