package array.find_the_celebrity_277;

/**
 * 277. Find the Celebrity
 * https://leetcode.com/problems/find-the-celebrity/?tab=Description
 * <p>
 * Suppose you are at a party with n people (labeled from 0 to n - 1)
 * and among them, there may exist one celebrity. The definition of a
 * celebrity is that all the other n - 1 people know him/her, but he/she
 * does not know any of them.
 * <p>
 * Now you want to find out who the celebrity is or verify that there
 * is not one. The only thing you are allowed to do is to ask questions
 * like: "Hi, A. Do you know B?" to get information of whether A knows B.
 * You need to find out the celebrity (or verify there is not one) by
 * asking as few questions as possible (in the asymptotic sense).
 * <p>
 * You are given a helper function bool knows(a, b) which tells you
 * whether A knows B. Implement a function int findCelebrity(n),
 * your function should minimize the number of calls to knows.
 * <p>
 * Note: There will be exactly one celebrity if he/she is in the
 * party. Return the celebrity's label if there is a celebrity
 * in the party. If there is no celebrity, return -1
 */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
// time - O(n), space O(1)

public class Solution extends Relation {
    int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (candidate != i && knows(i, candidate) && !knows(candidate, i)) cnt++;
        }
        return cnt == n - 1 ? candidate : -1;
    }
}