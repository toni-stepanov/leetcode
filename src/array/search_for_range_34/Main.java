package array.search_for_range_34;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {5,7,7,8,8,8,9,9,10};
        int[] nums2 = {1,2,2,4,5};
        int[] range = s.searchRange(nums,10);
        int[] range2 = s.searchRange(nums2,2);
        System.out.print(Arrays.toString(range2));
    }
}


