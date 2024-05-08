class Solution {
    private int findMax(int n){
        int max=0;
        while(n>0){
            int temp = n%10;
            if(temp>max)
                    max=temp;
            n=n/10;
        }
        return max;
    }
    public int maxSum(int[] nums) {
        int[] max = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++)
                max[i] = findMax(nums[i]);
        int ans=-1;
        for(int i=0 ; i<nums.length ; i++){
            for(int j=i+1 ; j<nums.length ; j++){
                if(max[i]==max[j])
                    ans = Math.max(ans,nums[i]+nums[j]);
            }
        }
        return ans;
        
    }
}