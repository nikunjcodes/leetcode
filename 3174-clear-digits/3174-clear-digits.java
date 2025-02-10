import java.util.Stack;

class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}