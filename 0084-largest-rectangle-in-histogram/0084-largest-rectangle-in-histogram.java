class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans=0;
        Stack<Integer> st = new Stack<Integer>();
        int n = heights.length;
        for(int i=0 ; i<=n ; i++){
            while(!st.isEmpty()  && (i==n || heights[st.peek()] >=heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width = st.isEmpty() ? i : i-st.peek()-1;
                ans = Math.max(ans , width*height);
            }
            st.push(i);
        }
        return ans;
    }
}