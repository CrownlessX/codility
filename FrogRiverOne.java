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

