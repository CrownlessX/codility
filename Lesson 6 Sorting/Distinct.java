/**
Write a function

    int solution(int A[], int N);

that, given an array A consisting of N integers, returns the number of distinct values in array A.

For more information: https://app.codility.com/programmers/lessons/6-sorting/distinct/
*/

//Detected time complexity: O(N*log(N)) or O(N)
import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] A) {
        Set<Integer> intSet = Arrays.stream(A)
            .boxed()
            .collect(Collectors.toSet());

        return intSet.size();
    }
}