import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }

        String result = sb.substring(start);
        return result.isEmpty() ? "0" : result;
    }
}
