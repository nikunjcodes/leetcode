class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE( arr);
        int[] pse = findPSE( arr);
        long ans =0;
        int  left=0 , right=0 ;
        int modulo = 1000000007;
        for(int i=0 ; i<arr.length ; i++){
            left = i-pse[i];
            right = nse[i] - i;
            ans =(ans+((long)left*right%modulo)*arr[i]%modulo)%modulo;
        }
        return (int)ans;
    }
    int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st=  new Stack<Integer>();
        for(int i = n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >=arr[i])
                st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    int[] findPSE(int[] arr){
        int n = arr.length;
        int[] pse  = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i= 0 ; i<n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >arr[i])
                st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}