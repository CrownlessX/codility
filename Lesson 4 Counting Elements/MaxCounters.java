/**
You are given N counters, initially set to 0, and you have two possible operations on them:

        increase(X) − counter X is increased by 1,
        max counter − all counters are set to the maximum value of any counter.

A non-empty array A of M integers is given. This array represents consecutive operations:

        if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
        if A[K] = N + 1 then operation K is max counter.
        
For more info: https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
**/

import java.util.*;

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int maxVal = 0;
        int maxCounter = 0;
        int[] results = new int[N];

        for (int i : A) {
            if (i <= N) {
                results[i - 1] = Math.max(results[i - 1], maxCounter);
                results[i - 1]++;
                maxVal = Math.max(results[i - 1], maxVal);
            } else {
                maxCounter = maxVal;
            }  
        }
        
        for (int i = 0; i < N; i++) {
            results[i] = Math.max(results[i], maxCounter);
        }
        
        return results;
    }
}