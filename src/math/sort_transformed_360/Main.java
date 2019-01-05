package math.sort_transformed_360;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.sortTransformedArray(new int[]{-1, 2, 3},1,2,3) ;
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}