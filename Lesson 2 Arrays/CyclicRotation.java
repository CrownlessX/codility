/**
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index,
and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
(elements are shifted right by one index and 6 is moved to the first place).
The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

For more information: https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
*/

//Complexity: O(N)
class Solution {
    public int[] solution(int[] A, int K) {
        int aLen = A.length;
        if (aLen == 0)
            return new int[0];

        int[] result = new int[aLen];

        while (K > aLen) {
            K -= aLen;
        }

        int backIndex = aLen - K;
        for (int i = 0; i < K; i++) {
            result[i] = A[backIndex++];
        }

        for (int i = 0; i < (aLen - K); i++) {
            result[K + i] = A[i];
        }

        return result;
    }
}
