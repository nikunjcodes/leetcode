class Solution {
    public String removeStars(String s) {
       Stack<Character> st=  new Stack<>();
       for(char c : s.toCharArray()){
        if(c=='*')
            st.pop();
        else
            st.push(c);
       } 
       StringBuilder ans= new StringBuilder();
       while(!st.isEmpty()){
        ans.append(st.pop());
       }
       return ans.reverse().toString();
    }
}