package math.minimum_moves_453;

/*
453. Minimum Moves to Equal Array Elements
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
 where a move is incrementing n - 1 elements by 1.
Example:

Input:
[1,2,3]
Output:
3
Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
**/
class Solution {

    int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num:nums) {
            if (num < min) {
                min = num;
            }
        }
        int ans = 0;
        for (int num:nums) {
            ans += num - min;
        }
        return ans;
    }

    //Incrementing n-1 elements by 1 = decrementing one element by 1.
    //The goal is to make all the elements equal. So the thought process for this is - first identify max among all, bring it down to min. How many steps did we take? (max-min).
    //Now, we need to repeat the process for the current max now. Eventually all the elements in the array will be equal to min.
    //So, in total, how many steps did we take? every element is trimmed by a[i]-min. So the answer is sum of all - min*# of elements.
    public int minMoves2(int[] nums) {
        int min = nums[0], sum = nums[0];
        for(int i=1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        return sum-min*nums.length;
    }

}