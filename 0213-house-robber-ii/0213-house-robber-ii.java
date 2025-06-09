class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        int[] first =new int[n];
        int[] second = new int[n];
        for(int i=0  ; i<nums.length ; i++){
            if(i!=0)
                first[i] = nums[i];
            if(i!=n-1)
                second[i] = nums[i];
        }
        return Math.max(helper(first) , helper(second));
    }
    int helper(int[] nums){
               int prev=nums[0];
        int prev2 = 0;
        for(int i=1 ; i<nums.length ; i++){
            int take = nums[i];
            if(i>1)
                take+=prev2;
            int not = prev;
            prev2=prev;
            prev= Math.max(take , not);
        }
        return prev;
    }
}