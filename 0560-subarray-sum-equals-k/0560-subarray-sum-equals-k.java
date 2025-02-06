class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int ans=0;
        Map<Integer , Integer> sum = new HashMap<>();
        sum.put(0,1);
        int temp=0;
        for(int i=0 ; i<nums.length ; i++){
            temp+=nums[i];
            if(sum.containsKey(temp-k))
                ans+=sum.get(temp-k);
            sum.put(temp , sum.getOrDefault(temp,0)+1);
        }   
        return ans;
    }
}