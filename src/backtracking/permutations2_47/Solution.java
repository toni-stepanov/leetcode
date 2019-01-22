package backtracking.permutations2_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
47. Permutations II
https://leetcode.com/problems/permutations-ii/#/description

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
//https://discuss.leetcode.com/topic/31445/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote
// https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
public class Solution {

    List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> pmtList = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();  // Decision space:  store nums left
        Arrays.sort(nums);
        for(int i : nums)
        {
            numsList.add(i);
        }

        buildPermute(resList, pmtList, numsList);
        return resList;
    }

    private void buildPermute(List<List<Integer>> resList, List<Integer> pmtList, List<Integer> numsList)
    {
        //base case
        if( numsList.size() == 0)
        {
            resList.add(pmtList);
            return;
        }

        for(int i=0; i < numsList.size(); i++)
        {
            if( i > 0 && numsList.get(i) == numsList.get(i-1))  continue; // skip duplicates
            List<Integer> newPmtList= new ArrayList<Integer>(pmtList);
            newPmtList.add(numsList.get(i));
            List<Integer> newNumsList= new ArrayList<Integer>(numsList);
            newNumsList.remove(i);
            buildPermute(resList, newPmtList, newNumsList);
        }
    }
}