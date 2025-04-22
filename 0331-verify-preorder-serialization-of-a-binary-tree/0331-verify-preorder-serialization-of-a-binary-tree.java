class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null)
            return true;
        String[] arr = preorder.split(",");
        Stack<String> st = new Stack<>();
        for(int i=0 ; i<arr.length ; i++){
            String curr = arr[i];
            while(curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)){
                st.pop();
                if(st.isEmpty())
                    return false;
                st.pop();
            }
            st.push(curr);
        }
        return st.size()==1 && st.peek().equals("#");


            
        


    }
}