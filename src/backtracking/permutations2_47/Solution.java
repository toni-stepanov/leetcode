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
        List<Integer> source = new ArrayList<>();  // Decision space:  store nums left
        Arrays.sort(nums);
        for(int i : nums)
        {
            source.add(i);
        }
        buildPermute(resList, pmtList, source);
        return resList;
    }

    private void buildPermute(List<List<Integer>> resList, List<Integer> current, List<Integer> source)
    {
        //base case
        if( source.isEmpty())
        {
            resList.add(current);
            return;
        }
        for(int i=0; i < source.size(); i++)
        {
            if( i > 0 && source.get(i).equals(source.get(i - 1)))  {
                continue;
            } // skip duplicates
            List<Integer> newCurrent= new ArrayList<>(current);
            newCurrent.add(source.get(i));
            List<Integer> newSource = new ArrayList<>(source);
            newSource.remove(i);
            buildPermute(resList, newCurrent, newSource);
        }
    }
}