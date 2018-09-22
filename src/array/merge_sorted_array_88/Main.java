package array.merge_sorted_array_88;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,7,0,0,0,0};
        int[] b = {2,3,4,5};
        s.merge(a, 2, b, 4);
        System.out.println(Arrays.toString(a));
        int[] a2 = {1,3,6,0,0};
        int[] b2 = {1,2,5};
        s.merge(a2, 3, b2, 3);
        System.out.println(Arrays.toString(a2));
        int[] a3 = {0};
        int[] b3 = {1};
        s.merge(a3, 0, b3, 1);
        System.out.println(Arrays.toString(a3));
        int[] a4 = {2,0};
        int[] b4 = {1};
        s.merge(a4, 1, b4, 1);
        System.out.println(Arrays.toString(a4));
    }

}


