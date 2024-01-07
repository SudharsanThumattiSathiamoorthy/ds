package com.sudhar.examples;
//
//Approach 3(Approach to follow up question)
//        This approach makes use of the fact that if i is a factor of n then n/i is also a factor of n. Lets try to understand this statement with an example.
//
//        Lets say n is 12.

import java.util.ArrayList;
import java.util.List;

//     We can see that for every i which is factor, n/i is also a factor. This fact helps us in reducing the number of iterations. After a point, the factor pairs starts repeating. (Highligthed in red)
//
//        So, we can stop before they stop repeating. Lets try to find of when they are repeating. As we can see, as soon the i > n/i, the pairs starts repeating and hence we can stop as soon as i becomes greater than n/i.
//
//        i > n/i can also be written as i * i > n. In short we can stop iterating as soon square of i becomes greater than n i.e we can continue the loop until i * i <= n.
//
//        So, for every factor, we can add i and n/i as their factors.
//
//        Lets store i in a list called factors and n/i in a list called factorPairs.
//
//        For our example, the lists are
//
//        Factors: 1 2 3
//        FactorPairs: 12 6 4
//
//        If there are m factors, the factors list consists of 1st, 2nd, 3rd, ..... factors and factorPairs list consits of mth, (m - 1)st, (m - 2)nd, .... factors.
//
//        At the end of the loop, one of the three cases can occur
//
//        There is no kth factor of n - In this case, the sum of sizes of both the lists is less than k. So we can return -1.
//        The kth factor is in factors list - If the size of factors list is greater than eqaul to k, that means that our kth factor is in factors list and hence return kth element of the factors list.
//        The kth factor is in FactorPairs List - If k is greater than size of factors list, the kth factor is in the other list. Now, a big question is that at which index of factorPairs does the kth factor exist. To get this, we can subtract the size of factors list from k and get the difference i.e k = k - factors.size(). Now, we simply have to get the kth element from the end of factorPairs list as we are storing the factors in reverse in factorPairs i.e return factorPairs.get(factorPairs.size() - k).
//        Edge case: One edge case that might cause a trouble is when i is a factor and i is equal to n/i, then we will be adding both i and n/i to the lists which is a duplicate one. Lets try to understand with an example.
//
//        Lets say we have n as 16. If i is 4, then n/i is also 4 and hence we will be adding 4 to factors list and 4 to factorPair list. To avoid this, we can just add a condition while adding n/i to factorPair list i.e only add if i and n/i are not equal.
//
//        Complexity
//        Time complexity: As we are looping from 1 to sqrt(n), the time complexity will be order of n i.e O(sqrt(n)).
//        Space complexity: O(sqrt(n)) as we can have sqrt(n) factors.
public class TheKthFactorOfN {

    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>(), revFactors = new ArrayList<>();
        for(int factor = 1; factor * factor <= n; factor++){
            if(n % factor == 0){
                factors.add(factor);
                if(n/factor != factor) // To avoid duplicate(edge case)
                    revFactors.add(n/factor);
            }
        }
        if(factors.size() + revFactors.size() < k) // Case 1
            return -1;
        if(factors.size() >= k) // Case 2
            return factors.get(k - 1);
        k -= factors.size();
        return revFactors.get(revFactors.size() - k); // Case 3
    }

    class Solution {
        public int kthFactor(int n, int k) {
            int curr = 0;
            for(int factor = 1; factor <= n; factor++){
                if(n % factor == 0)
                    curr++;
                if(curr == k)
                    return factor;
            }
            return -1;
        }
    }
}
