class Solution {
    public int fib(int n) {
       int[] arr = new int[n+1];
       Arrays.fill(arr , -1);
       return helper(n , arr);
    }
    int helper(int n , int [] arr){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(arr[n]!=-1)
            return arr[n];
        else
            return arr[n] = (helper(n-1 , arr) + helper(n-2 , arr));
    }
}