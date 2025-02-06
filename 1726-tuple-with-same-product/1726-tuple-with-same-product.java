class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int ans=0;
        for(int i=0 ; i<nums.length ; i++){
            for(int j=i+1; j<nums.length ; j++){
                int count = map.getOrDefault(nums[i]*nums[j] , 0);
                ans+=count;
                map.put(nums[i]*nums[j],  count+1);
            }
        }
        return ans*8;
    }
}