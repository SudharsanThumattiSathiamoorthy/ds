package com.sudhar.examples;

public class MaximumAverageSubarrayII {

    public class Solution1 {
        public double findMaxAverage(int[] nums, int k) {
            double res = Integer.MIN_VALUE;
            for (int s = 0; s < nums.length - k + 1; s++) {
                long sum = 0;
                for (int i = s; i < nums.length; i++) {
                    sum += nums[i];
                    if (i - s + 1 >= k)
                        res = Math.max(res, sum * 1.0 / (i - s + 1));
                }
            }
            return res;
        }
    }




//    Approach #2 Using Binary Search [Accepted]
//    Algorithm
//
//    To understand the idea behind this method, let's look at the following points.
//
//    Firstly, we know that the value of the average could lie between the range (min, max)(min,max). Here, minmin and maxmax refer to the minimum and the maximum values out of the given numsnums array. This is because, the average can't be lesser than the minimum value and can't be larger than the maximum value.
//
//            But, in this case, we need to find the maximum average of a subarray with atleast kk elements. The idea in this method is to try to approximate(guess) the solution and to try to find if this solution really exists.
//
//    If it exists, we can continue trying to approximate the solution even to a further precise value, but choosing a larger number as the next approximation. But, if the initial guess is wrong, and the initial maximum average value(guessed) isn't possible, we need to try with a smaller number as the next approximate.
//
//    Now, instead of doing the guesses randomly, we can make use of Binary Search. With minmin and maxmax as the initial numbers to begin with, we can find out the midmid of these two numbers given by (min+max)/2(min+max)/2. Now, we need to find if a subarray with length greater than or equal to kk is possible with an average sum greater than this midmid value.
//
//    To determine if this is possible in a single scan, let's look at an observation. Suppose, there exist jj elements, a_1, a_2, a_3..., a_ja
//            1
//            ​
//            ,a
//2
//        ​
//        ,a
//3
//        ​
//        ...,a
//            j
//​
//    in a subarray within numsnums such that their average is greater than midmid. In this case, we can say that
//
//            (a_1+a_2+ a_3...+a_j)/j ≥ mid or
//
//            (a_1+a_2+ a_3...+a_j) ≥ j*mid or
//
//            (a_1-mid) +(a_2-mid)+ (a_3-mid) ...+(a_j-mid) ≥ 0
//
//    Thus, we can see that if after subtracting the midmid number from the elements of a subarray with more than k-1k−1 elements, within numsnums, if the sum of elements of this reduced subarray is greater than 0, we can achieve an average value greater than midmid. Thus, in this case, we need to set the midmid as the new minimum element and continue the process.
//
//    Otherwise, if this reduced sum is lesser than 0 for all subarrays with greater than or equal to kk elements, we can't achieve midmid as the average. Thus, we need to set midmid as the new maximum element and continue the process.
//
//    In order to determine if such a subarray exists in a linear manner, we keep on adding nums[i]-midnums[i]−mid to the sumsum obtained till the i^{th}i
//            th
//    element while traversing over the numsnums array. If on traversing the first kk elements, the sumsum becomes greater than or equal to 0, we can directly determine that we can increase the average beyond midmid. Otherwise, we continue making additions to sumsum for elements beyond the k^{th}k
//            th
//    element, making use of the following idea.
//
//    If we know the cumulative sum upto indices ii and jj, say sum_isum
//    i
//​
//    and sum_jsum
//    j
//​
//    respectively, we can determine the sum of the subarray between these indices(including jj) as sum_j - sum_isum
//            j
//​
//        −sum
//            i
//​
//        . In our case, we want this difference between the cumulative sums to be greater than or equal to 0 as discusssed above.
//
//            Further, for sum_isum
//            i
//​
//    as the cumulative sum upto the current(i^{th}i
//            th
// ) index, all we need is sum_j - sum_i ≥ 0 such that j - i ≥ k.
//
//    To achive this, instead of checking with all possible values of sum_isum
//            i
//​
//        , we can just consider the minimum cumulative sum upto the index j - kj−k. This is because if the required condition can't be sastisfied with the minimum sum_isum
//    i
//​
//        , it can never be satisfied with a larger value.
//
//    To fulfil this, we make use of a prevprev variable which again stores the cumulative sums but, its current index(for cumulative sum) lies behind the current index for sumsum at an offset of kk units. Thus, by finding the minimum out of prevprev and the last minimum value, we can easily find out the required minimum sum value.
//
//    Every time after checking the possiblility with a new midmid value, at the end, we need to settle at some value as the average. But, we can observe that eventually, we'll reach a point, where we'll keep moving near some same value with very small changes. In order to keep our precision in control, we limit this process to 10^-510
//            −
//            5 precision, by making use of errorerror and continuing the process till errorerror becomes lesser than 0.00001 .

    public class Solution2 {
        public double findMaxAverage(int[] nums, int k) {
            double max_val = Integer.MIN_VALUE;
            double min_val = Integer.MAX_VALUE;
            for (int n: nums) {
                max_val = Math.max(max_val, n);
                min_val = Math.min(min_val, n);
            }
            double prev_mid = max_val, error = Integer.MAX_VALUE;
            while (error > 0.00001) {
                double mid = (max_val + min_val) * 0.5;
                if (check(nums, mid, k))
                    min_val = mid;
                else
                    max_val = mid;
                error = Math.abs(prev_mid - mid);
                prev_mid = mid;
            }
            return min_val;
        }
        public boolean check(int[] nums, double mid, int k) {
            double sum = 0, prev = 0, min_sum = 0;
            for (int i = 0; i < k; i++)
                sum += nums[i] - mid;
            if (sum >= 0)
                return true;
            for (int i = k; i < nums.length; i++) {
                sum += nums[i] - mid;
                prev += nums[i - k] - mid;
                min_sum = Math.min(prev, min_sum);
                if (sum >= min_sum)
                    return true;
            }
            return false;
        }
    }

}
