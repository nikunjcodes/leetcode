class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int l = s.length();
        for(int i=0 ; i<l ;i++){
            char temp = s.charAt(i);
            if(temp=='(' || temp=='[' || temp == '{'){
                st.push(temp);
            }
            else{
                if(st.isEmpty())
                    return false;
                else{
                    char c = s.charAt(i);
                    char top = st.pop();
                if((c==')' && top!='(')|| (c==']' && top!='[') || (c=='}' && top!='{'))
                    return false;
                }
            }
        }
        if(st.isEmpty())
            return true;
        else
            return false;
    }
}