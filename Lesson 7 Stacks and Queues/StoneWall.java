/**
You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

For more info: https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
*/

//Detected time complexity: O(N)
import java.util.Stack;

class Solution {

    public int solution(int[] H) {
        int blockCounter = 0;
        Stack<Integer> wallSpace = new Stack<Integer>();         
        
        for (int i = 0; i < H.length; i++) {
            if (wallSpace.isEmpty()) {
                wallSpace.push(H[i]);
            }
            
            if (H[i] > wallSpace.peek()) {
                wallSpace.push(H[i]);
            } else if (H[i] < wallSpace.peek()) {
                while(!wallSpace.isEmpty() && H[i] < wallSpace.peek()) {
                    blockCounter++;
                    wallSpace.pop();    
                }

                if (wallSpace.isEmpty() || H[i] != wallSpace.peek()) {
                    wallSpace.push(H[i]);    
                }
            }
        }
        return blockCounter + wallSpace.size();
    }
}

