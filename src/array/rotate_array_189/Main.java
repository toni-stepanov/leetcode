package array.rotate_array_189;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1,2,3,4,5,6,7};
        s.rotate(array, 3);
        System.out.print(Arrays.toString(array));
    }
}


