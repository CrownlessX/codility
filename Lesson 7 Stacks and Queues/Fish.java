/**
You are given two non-empty arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river.

The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q. Initially, each fish has a unique position.

Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All its elements are unique. Array B contains the directions of the fish. It contains only 0s and/or 1s, where:

        0 represents a fish flowing upstream,
        1 represents a fish flowing downstream.

If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they meet:

        If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
        If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.

We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.

For more info: https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
**/

//Detected time complexity: O(N)
import java.util.Stack;

class Solution {
    public int solution(int[] A, int[] B) {
        int alive = A.length;
        Stack<Integer> downStreamFishes = new Stack<>();
        
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                downStreamFishes.push(A[i]);
            } else {
                while (!downStreamFishes.isEmpty()) {
                    alive--;
                    if (downStreamFishes.peek() < A[i] ) {
                            downStreamFishes.pop();
                    } else {
                        break;
                    }
                }

            }
        }
        return alive;        
    }
}

