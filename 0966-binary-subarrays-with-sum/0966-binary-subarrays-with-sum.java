class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] map = new int[nums.length+1];
        int ans=0;
        int sum=0;
        map[0] =1;
        for(int num : nums){
            sum+=num;
            if(sum>=goal)
                ans+=map[sum-goal];
            map[sum]++;
        }
        return ans;
    }
}