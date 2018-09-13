/** 
A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For more information: https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
*/

//Detected time complexity: O(N * log(N))
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        
        int leftMax = A[0] * A[1] * A[len - 1];
        int rightMax = A[len - 3] * A[len - 2] * A[len - 1];

        return Math.max(leftMax, rightMax);
    }
}