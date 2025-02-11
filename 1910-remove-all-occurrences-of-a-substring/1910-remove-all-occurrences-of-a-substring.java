class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            stack.push(c);
            if(stack.size() >= part.length() && stack.peek() == part.charAt(part.length()-1)) {
                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < part.length(); i++) {
                    temp.append(stack.pop());
                }
                temp.reverse();
                if(!temp.toString().equals(part)) {
                    for( char ct : temp.toString().toCharArray()) {
                        stack.push(ct);
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}