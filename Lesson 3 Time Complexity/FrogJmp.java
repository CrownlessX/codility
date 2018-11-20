/**
A small frog wants to get to the other side of the road. The frog is currently located at position X
and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

For mor info: https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
*/

//Detected time complexity: O(1)
class Solution {
    public int solution(int X, int Y, int D) {
        int minJumps = (Y - X) / D;
        if (((Y - X) % D) != 0) { //Add 1 jump, if we didn't reaced end position
            minJumps++;
        }
        return minJumps;
    }
}
