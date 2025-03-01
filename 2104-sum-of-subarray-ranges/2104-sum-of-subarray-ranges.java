class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int pge[] = new int[n];
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && nums[st.peek()] <=nums[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st = new Stack<>();
        for(int i=0 ; i<n ; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i])
                st.pop();
            pge[i] = st.isEmpty()?-1 : st.peek();
            st.push(i);
        }
        long maxsum=0;
        for(int i=0 ; i<n ; i++){
            long left = i-pge[i];
            long right = nge[i] -i;
            maxsum+=left*right*nums[i];
        }
        int pse[] = new int[n];
        int nse[] = new int[n];
        st=new Stack<>();
        for(int i= n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])
                st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st = new Stack<>();
        for(int i=0 ; i<n ;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i])
                st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        long minsum=0;
        for(int i=0 ; i<n ; i++){
            long left= i-pse[i];
            long right = nse[i] -i;
            minsum+=left*right*nums[i];
        }
        return maxsum - minsum;
    }
}