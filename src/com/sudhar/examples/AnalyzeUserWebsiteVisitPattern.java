package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AnalyzeUserWebsiteVisitPattern {

//    We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
//
//    A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)
//
//    Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.
//
//
//
//            Example 1:
//
//    Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
//    Output: ["home","about","career"]
//    Explanation:
//    The tuples in this example are:
//            ["joe", 1, "home"]
//            ["joe", 2, "about"]
//            ["joe", 3, "career"]
//            ["james", 4, "home"]
//            ["james", 5, "cart"]
//            ["james", 6, "maps"]
//            ["james", 7, "home"]
//            ["mary", 8, "home"]
//            ["mary", 9, "about"]
//            ["mary", 10, "career"]
//    The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
//            The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
//            The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
//            The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
//            The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
//
//
//            Note:
//
//            3 <= N = username.length = timestamp.length = website.length <= 50
//            1 <= username[i].length <= 10
//            0 <= timestamp[i] <= 10^9
//            1 <= website[i].length <= 10
//    Both username[i] and website[i] contain only lowercase characters.
//    It is guaranteed that there is at least one user who visited at least 3 websites.
//    No user visits two websites at the same time.

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair<Integer, String>>> map = new TreeMap<>();

        for(int i=0; i<username.length; i++){
            if(!map.containsKey(username[i])) map.put(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        Map<String, Integer> countMap = new TreeMap<>();

        for(String user: map.keySet()){
            List<Pair<Integer, String>> currList = map.get(user);
            Collections.sort(currList, (n1, n2) -> (n1.getKey() - n2.getKey()));
            StringBuilder sb = new StringBuilder();
            Set<String> set = new HashSet<>();
            for(int i=0; i<currList.size()-2; i++){
                int length1 = sb.length();
                sb.append(currList.get(i).getValue());
                for(int j=i+1; j<currList.size()-1; j++){
                    int length2 = sb.length();
                    sb.append("-");
                    sb.append(currList.get(j).getValue());
                    for(int k=j+1; k<currList.size(); k++){
                        int length3 = sb.length();
                        sb.append("-");
                        sb.append(currList.get(k).getValue());
                        if(!set.contains(sb.toString())){
                            countMap.put(sb.toString(), countMap.getOrDefault(sb.toString(), 0) + 1);
                            set.add(sb.toString());
                        }
                        sb.delete(length3, sb.length());
                    }
                    sb.delete(length2, sb.length());
                }
                sb.delete(length1, sb.length());
            }
        }

        int maxCount = Collections.max(countMap.values());

        List<String> list = new ArrayList<>();
        for(String s: countMap.keySet()){
            if(countMap.get(s) == maxCount){
                list.add(s);
            }
        }

        Collections.sort(list);

        return Arrays.asList(list.get(0).split("-"));
    }
}
