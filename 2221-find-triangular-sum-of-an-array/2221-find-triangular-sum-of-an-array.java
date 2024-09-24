class Solution {
    public int triangularSum(int[] nums) {
        int sum = helper(nums);
        return sum;
    }
    int helper(int[] nums){
        if(nums.length == 1)
            return nums[0];
        else{
            int[] newNums = new int[nums.length-1];
            for(int i=0 ; i<nums.length-1 ; i++)
                newNums[i] = (nums[i]+ nums[i+1])%10;
        
        return helper(newNums);
    }
}
}