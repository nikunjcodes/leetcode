class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer , Integer> hmap = new HashMap<>();
        hmap.put(0,-1);
        int sum=0;
        int ans=0;
        for(int i=0 ; i<nums.length ; i++){
            sum+=(nums[i]==0) ? -1 : 1 ;
            if(!hmap.containsKey(sum))
                hmap.put(sum , i);
            ans = Math.max(ans , i-hmap.get(sum));
        }
        return ans;

    }
}