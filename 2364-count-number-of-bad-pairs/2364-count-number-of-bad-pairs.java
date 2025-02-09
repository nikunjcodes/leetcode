class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        long ans=0;
        for(int i=0 ; i<nums.length ; i++){
            int cnt = map.getOrDefault(i-nums[i] , 0);
            ans+=cnt;
            map.put(i-nums[i] , cnt+1);
        }
        int n = nums.length;
        return 1L*n*(n-1)/2 - ans;
    }
}