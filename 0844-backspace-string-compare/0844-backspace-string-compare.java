class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for(char i : sa){
            if(i=='#'){
                if(!st1.isEmpty())
                    st1.pop();
            }
            else
                st1.push(i);
        }
        for(char i : ta){
            if(i=='#'){
                if(!st2.isEmpty())
                    st2.pop();
            }
            else
                st2.push(i);            
        }
        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st1.pop() != st2.pop())
                    return false;
        }
        return (st1.isEmpty() && st2.isEmpty());
    }
}