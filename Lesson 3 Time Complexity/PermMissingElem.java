/**
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)],
 which means that exactly one element is missing.

Your goal is to find that missing element.

For more info: https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
*/

// 1) Sorting + searching
//Detected time complexity: O(N) or O(N * log(N))
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        Arrays.sort(A);
        for (int i = 1; i < A.length + 1; i++) {
            if (i != A[i - 1]) {
                return i;
            }
        }
        return A[A.length - 1] + 1;
    }
}


// 2) With checker
//Detected time complexity: O(N)
class Solution {
    public int solution(int[] A) {

        if (A.length == 0) {
            return 1;
        }
        int aSum = 0;
        for (int i : A) {
            aSum += i;
        }

        int checkSum = 0;
        for (int i = 1; i < A.length + 2; i++) {
            checkSum += i;
        }

        int diff = checkSum - aSum;
        if (diff == 0) {
            return A[A.length - 1] + 1;
        } else {
            return diff;
        }
    }
}
