/**
A string S consisting of N characters is called properly nested if:

        S is empty;
        S has the form "(U)" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.


For more info: 
https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
*/

/** Non-Stack version */
//Detected time complexity: O(N)
class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        if (S.isEmpty()) 
            return 1;
        
        int openBrackets = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                openBrackets++;
            } else {
                if (openBrackets > 0) {
                    openBrackets--;
                } else {
                    return 0;
                }
            }
        }
        if (openBrackets == 0) {
            return 1; 
        } else {
            return 0;
        }
    }
}

/** Stack version */
//Detected time complexity: O(N)
import java.util.Stack;

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        if (S.isEmpty()) {
            return 1;
        }
        
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            brackets.push(S.charAt(i));
        }
        
        int closeBrackets = 0;        
        
        while(!brackets.empty()) {
            Character c = brackets.pop();
            if (c == ')') {
                closeBrackets++;    
            } else {
                if (closeBrackets > 0) {
                    closeBrackets--;
                } else {
                    return 0;
                }
            }
        }
        
        if (closeBrackets == 0) 
            return 1;
        return 0;
    }
}