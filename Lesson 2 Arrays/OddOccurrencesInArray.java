/**
A non-empty array A consisting of N integers is given. The array contains an odd number of elements,
and each element of the array can be paired with another element that has the same value, except for
one element that is left unpaired.

For more info: https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
*/

//Detected time complexity: O(N)
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        if (len == 1) {
            return A[0];
        }

        //To use minus/plus operations right we have to sort array
        Arrays.sort(A);
        
        int sum = 0;
        //As we got pairs, thair diff will give us 0. So array diff
        //will be our searching int
        for (int i = 0; i < len; i++) {
            sum += i % 2 == 0 ? A[i] : -A[i];
        }
        return Math.abs(sum);
    }
}
