/**
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

        S is empty;
        S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.

For more info: https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
*/

//Detected time complexity: O(N)
import java.util.Stack;

class Solution {
    
    public int solution(String S) {
        Stack<Character> brackets = new Stack<>(); //()
        
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                brackets.push(c);
            } else {
                if (brackets.isEmpty())
                    return 0;
                Character openBracket = brackets.pop();
                if (openBracket == '(' && c != ')' || 
                    openBracket == '{' && c != '}' || 
                    openBracket == '[' && c != ']') 
                    return 0;
            }
        }
        if (brackets.isEmpty()) 
            return 1;
        return 0;
    }
}