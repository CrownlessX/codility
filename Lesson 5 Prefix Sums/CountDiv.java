/**
Write a function:

    class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

    { i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

        A and B are integers within the range [0..2,000,000,000];
        K is an integer within the range [1..2,000,000,000];
        A ≤ B.
        
For more info: https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
*/

//Detected time complexity: O(1)
class Solution {

    public int solution(int A, int B, int K) {
        int firstDivVal = -1;
        
        //We could divide 0 by any value.
        if (A == 0) { 
            firstDivVal = 0;
        } else {
            for (int i = A; i <= B; i++) {
                if (i % K == 0) {
                    firstDivVal = i;
                    break;
                }
            }
            
            //Case when we didn't found any divisible values
            if (firstDivVal == -1)
                return 0;
        }

        int divCount = 1 + (B - firstDivVal) / K; //As firstDivVal already could be divided

        return divCount;
    }
}