/**
This is a demo task.

Write a function:

    int solution(int A[], int N);

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For more info: https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
*/

import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int count = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (A[i] == count - 1)
                    continue;
                if (A[i] != count)
                    return count;
                count++;
            }
        }
        
        if (count > 1)
            return count;
        return 1;
    }
}
