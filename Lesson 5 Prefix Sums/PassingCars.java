/**
A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

        0 represents a car traveling east,
        1 represents a car traveling west.

The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
For more info: https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
**/
import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int passCars = 0;
        int eastCars = 0, westCars = 0;
            
        for (int i : A) {
            if (i == 0) {
                eastCars++;
            } else {
                westCars++;
            }
        }
        
        for(int i : A) {
            if (i == 0) {
                eastCars--;
                passCars += westCars;
                if (passCars > 1000_000_000)
                    return -1;
            } else {
                //As 0 ≤ P < Q < N west traveling cars never moves :)
                westCars--;
            }
        }
        
        return passCars;
    }
}