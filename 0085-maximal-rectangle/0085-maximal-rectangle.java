class Solution {
    public int maximalRectangle(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans=0;
        int[][] psum = new int[m][n];
        for(int j=0 ; j<n ;j++){
            for(int i=0 ; i<m ; i++){
                if(mat[i][j]=='0')
                    psum[i][j]=0;
                else
                    psum[i][j] = (i==0)? 1 : psum[i-1][j]+1;
            }
        }
        for(int i=0 ; i<m ; i++)
            ans= Math.max(ans , helper(psum[i]));
        return ans;
    }
    public int helper(int[] heights) {
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