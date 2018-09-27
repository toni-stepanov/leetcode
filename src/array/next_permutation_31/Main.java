package array.next_permutation_31;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,3};
        s.nextPermutation(a);
        System.out.println("nextPermutation" +
                " = " + Arrays.toString(a));
    }
}