/**
This is a demo task.

Write a function:

    int solution(int A[], int N);

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For more info: https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
**/

import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        
        //If we first int more then 1, then we missing 1.
        //If the last int in sorted array less then 1, then we got negative array
        if (A[0] > 1 || A[A.length - 1] < 1)
            return 1;
        
        int prevVal = 0;
        for(int i = 0; i < A.length; i++) {
            //Skipping all nagetive elements
            if(A[i] < 1) {
                continue;                
            }

            //Check if we miss element between previous value and current
            if(A[i] > prevVal + 1) {
                return prevVal + 1;
            }
            prevVal = A[i];
        }    
                    
        //We reached end of array and didn't find the missing int. 
        //Then our int -> next after the last in our array
        return A[A.length - 1] + 1; 
    }
}

