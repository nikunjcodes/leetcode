class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int sum=0;
        int ans=0;
        Map<Integer , Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        for(int i=0 ; i<nums.length ; i++){
            sum+=nums[i]%2 ==1 ? 1 : 0;
            hmap.put(sum , hmap.getOrDefault(sum,0)+1);
            ans+=hmap.getOrDefault(sum-k ,0);
        }
        return ans;
    }
}