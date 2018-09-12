/**
A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
More info: https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
**/

//Detected time complexity: O(N)
class Solution {
    public int solution(int[] A) {
        double minAvgSlice = Integer.MAX_VALUE;
        int minIndex = 0;
        int len = A.length;
        for (int i = 0; i < len - 1; i++) {
            double curSliceAvg = (A[i] + A[i + 1]) / 2.0;
            if (i < len - 2) {
                double treeElemSliceAvg = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                curSliceAvg = Math.min(curSliceAvg, treeElemSliceAvg);
            }
            if (curSliceAvg < minAvgSlice) {
                minAvgSlice = curSliceAvg;
                minIndex = i;
            }
        }
        return minIndex;
    }
}