/**
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded
by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529
has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has
binary representation 1111 and has no binary gaps. Teh number 32 has binary representation 100000 and has
no binary gaps.

For more info: https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
*/

class Solution {
    public int solution(int N) {
        int maxGap = 0;
        int currGap = 0;
        char[] charArr = Integer.toBinaryString(N).toCharArray()
        for(char c : charArr) {
            if (c == '1') {
                maxGap = currGap > maxGap ? currGap : maxGap;
                currGap = 0;
            } else {
                currGap++;
            }
        }
        return maxGap;
    }
}
