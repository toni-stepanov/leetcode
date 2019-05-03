package graph.alien_dictionary_269;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
269. Alien Dictionary
https://leetcode.com/problems/alien-dictionary/

There is a new alien language which uses the latin alphabet.
However, the order among letters are unknown to you. You receive a
list of words from the dictionary, where words are sorted lexicographically
by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

w e r
r r r t
t f t
t

The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/
class Solution {
    private HashSet<Character> added;
    private StringBuilder sorted;
    private boolean hasCycle;

    String alienOrder(String[] words) {
        added = new HashSet<>();
        sorted = new StringBuilder();
        HashSet<Character> allChars = new HashSet<>();
        HashMap<Character,List<Character>> graph = new HashMap<>();
        if(words.length==1){
            for(char c : words[0].toCharArray()){
                allChars.add(c);
            }
        }
        for(int i=1; i<words.length; i++){
            String prev = words[i-1];
            String cur = words[i];
            int p = 0;
            while(p<prev.length() && p<cur.length()){
                char c1 = prev.charAt(p);
                char c2 = cur.charAt(p);
                allChars.add(c1);
                if(c1!=c2){
                    allChars.add(c1);
                    if(graph.containsKey(c2)){
                        graph.get(c2).add(c1);
                    }
                    else{
                        List<Character> list = new ArrayList<>();
                        list.add(c1);
                        graph.put(c2,list);
                    }
                    break;
                }
                p++;
            }
            if(p==cur.length() && cur.length()<prev.length()) return "";
            int pCopy = p;
            while(pCopy<prev.length()){
                allChars.add(prev.charAt(pCopy++));
            }
            pCopy = p;
            while(pCopy<cur.length()){
                allChars.add(cur.charAt(pCopy++));
            }
        }

        for(char c : allChars){
            dfs(graph,c,new HashSet<>());
            if(hasCycle) return "";
        }

        return sorted.toString();
    }

    private void dfs(HashMap<Character,List<Character>> graph, char cur, HashSet<Character> visited){
        if(added.contains(cur)) return;
        if(visited.contains(cur)){
            hasCycle = true;
            return;
        }
        visited.add(cur);
        if(graph.containsKey(cur)){
            for(char next : graph.get(cur)){
                dfs(graph,next,visited);
            }
        }
        visited.remove(cur);
        added.add(cur);
        sorted.append(cur);
    }
}
