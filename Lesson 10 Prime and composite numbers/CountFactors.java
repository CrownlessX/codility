/**
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

For more information: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
*/

//Detected time complexity: O(sqrt(N))
class Solution {
    public int solution(int N) {
        int count = 0;
        for(int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                if (i * i == N) {
                   count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
