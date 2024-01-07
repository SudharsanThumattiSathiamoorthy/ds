package com.sudhar.examples;

import java.util.Arrays;

// I want to use example1 to explain this solution.
// we have candidates A, B, C. So we can record the number of votes in every position for each candidate.
// A: 5, 0, 0
// B: 0, 2, 3
// C: 0, 3, 2
// we imagine it is a 2D array. we try to sort the array. After sorting, we should make the array like this:
// A: 5, 0, 0
// C: 0, 3, 2
// B: 0, 2, 3
// Obviously, ACB is the result we want.

// Now, we just need to use coding to realizing it.

// we define an array, every row denote a candidate, every column denotes a position.
// we add an extra column to identify which candidate the row is.
// we record the number of votes in every position for each candidate by using for-loop
// sort the array. we define a method to compare candidates.
// after sorting, build string.
// The time complexity: O(26 + n * c + 26 * log 26 * c + c) = O(n).
// c is a constant number, and c <= 26.
public class RankTeamsByVotes {

    public static void main(String[] args) {
//        Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
//        Output: "ACB"
//        Explanation:
//        Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
//        Team B was ranked second by 2 voters and ranked third by 3 voters.
//                Team C was ranked second by 3 voters and ranked third by 2 voters.
//                As most of the voters ranked C second, team C is the second team, and team B is the third.

        rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"});

//        Input: votes = ["WXYZ","XYZW"]
//        Output: "XWYZ"
//        Explanation:
//        X is the winner due to the tie-breaking rule. X has the same votes as W for the first position,
//                but X has one vote in the second position,
//        while W does not have any votes in the second position.

       // rankTeams(new String[]{"WXYZ","XYZW"});
    }

    public static String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] map = new int[26][len + 1];
        for(int i = 0; i < 26; i++) map[i][len] = i;

        for(int i = 0; i < votes.length; i++){
            String s = votes[i];
            for(int j = 0; j < len; j++){
                map[s.charAt(j) - 'A'][j]++;
            }
        }

        // System.out.println(Arrays.deepToString(map));

        Arrays.sort(map, (a, b) ->{
            for(int i = 0; i < len; i++){
                if(a[i] < b[i]) return 1;
                if(a[i] > b[i]) return -1;
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){

            System.out.println( map[i][len]);

            sb.append((char)('A' + map[i][len]));
        }
        return sb.toString();
    }
}
