/**
A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For more info: https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
*/

import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        int[] checkArr = new int[X + 1];
        Arrays.fill(checkArr, -1);
        int minTime = 0;
        
        for(int i = 0; i < A.length; i++) {
            int elem = A[i];
            if(elem <= X) {
                if (checkArr[elem] == -1) {
                    checkArr[elem] = i;   
                }
            }
        }
        
        for(int i = 01; i < checkArr.length; i++) {
            if (checkArr[i] == -1) {
                return -1;   
            }
                
            minTime = Math.max(minTime, checkArr[i]);
        }
        return minTime;
    }
}

