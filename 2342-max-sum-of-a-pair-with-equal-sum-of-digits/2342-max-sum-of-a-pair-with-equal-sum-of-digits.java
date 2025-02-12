class Solution {
    public int maximumSum(int[] nums) {
        int ans=-1;
        int[] arr = new int[82];
        for(int num  : nums){
            int sum = helper(num);
            if(arr[sum] > 0)
                ans = Math.max(ans , arr[sum] + num);
            arr[sum] = Math.max(arr[sum] , num);
        }
        return ans;
    }
    int helper(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
}