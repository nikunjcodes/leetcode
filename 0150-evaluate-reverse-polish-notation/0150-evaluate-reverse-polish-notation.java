class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if(token.equals("+") ||token.equals("-") ||token.equals("*") ||token.equals("/")){
                int num1 = st.pop();
                int num2 = st.pop();
                if(token.equals("+"))
                    st.add(num1+num2);
                else if (token.equals("-"))
                    st.add(num2-num1);
                else if (token.equals("*"))
                    st.add(num1*num2);
                else if(token.equals("/")) 
                    st.add(num2/num1);
            }
            else
                    st.add(Integer.parseInt(token));
        }
        return st.pop();
    }
}