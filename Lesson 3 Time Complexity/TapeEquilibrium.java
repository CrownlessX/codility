/**
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For more info: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
*/

//Detected time complexity: O(N)

class Solution {
    public int solution(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        int leftVal = 0;
        int rightVal = sum;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            leftVal += A[i];
            rightVal -= A[i];
            int diff = Math.abs(leftVal - rightVal);
            if (diff < minDiff)
                minDiff = diff;
        }
        return minDiff;
    }
}
