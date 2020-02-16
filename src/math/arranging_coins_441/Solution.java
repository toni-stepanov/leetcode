package math.arranging_coins_441;

/*
441. Arranging Coins
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.
*/
class Solution {

    int arrangeCoins(int n) {
        int totalRows = 0;
        for (int i = 1; i <= n; i++) {
            n -= i;
            totalRows++;
        }
        return totalRows;
    }

}