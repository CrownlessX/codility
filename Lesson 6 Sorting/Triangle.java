/**
An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

        A[P] + A[Q] > A[R],
        A[Q] + A[R] > A[P],
        A[R] + A[P] > A[Q].

For more info: https://app.codility.com/programmers/lessons/6-sorting/triangle/
**/

//Detected time complexity: O(N*log(N))
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int len = A.length;

        for (int p = 0; p < len - 2; p++) {
            if (A[p] > A[p + 2] - A[p + 1]) {
                return 1;
            }
        }
        return 0;
    }
}
