package graph.reconstructItinerary_332;

import java.util.*;

/**
332. Reconstruct Itinerary
 https://leetcode.com/problems/reconstruct-itinerary/?tab=Description

Given a list of airline tickets represented by pairs of departure and arrival airports
[from, to], reconstruct the itinerary in order. All of the tickets belong to a man who
departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has
the smallest lexical order when read as a single string. For example, the itinerary
["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/
// https://discuss.leetcode.com/topic/36383/share-my-solution
// https://discuss.leetcode.com/topic/36370/short-ruby-python-java-c
// In dfs and dfs1 we start our itinerary from the final point.
// So when we find the vertex with 0 out degree (no flights from there) - this is the final point.
// Then we back to the previous point and check adjacent vertex from it.
// This graph contains Eularian path (maybe Eularian cycle).
// Check algorithms to find the Eularian path (cycle) in directed and undirected graph.
public class Solution {

    Map<String, PriorityQueue<String>> flights = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) return itinerary;
        for(String[] ticket : tickets) {
            String depature = ticket[0], arrival = ticket[1];
            flights.putIfAbsent(depature, new PriorityQueue<>());
            flights.get(depature).add(arrival);
        }
        dfs1("JFK");
        return itinerary;
    }

    void dfs1(String depature) {
        PriorityQueue<String> arrivals = flights.get(depature);
        while (arrivals != null && !arrivals.isEmpty()) {
            String arrival = arrivals.poll(); // remove the arrival from graph
            dfs1(arrival);
        }
        itinerary.addFirst(depature);
    }

//    void dfs(String departure) {
//        Stack<String> stack = new Stack<>();
//        stack.push(departure);
//        while (!stack.isEmpty()) {
//            String curr = stack.peek();
//            PriorityQueue<String> arrivals = flights.get(curr);
//            if (arrivals == null || arrivals.isEmpty()) {
//                itinerary.addFirst(curr);
//                stack.pop();
//            } else {
//                String next = arrivals.poll();
//                stack.push(next);
//            }
//        }
//    }
}