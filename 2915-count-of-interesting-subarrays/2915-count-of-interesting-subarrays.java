class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans=0;
        int temp=0;
        HashMap<Integer , Integer> hmap = new HashMap<>(Map.of(0,1));
        for(int num : nums){
            temp = (temp + (num%modulo==k ? 1 : 0))%modulo;
            ans+=hmap.getOrDefault((temp-k+modulo)%modulo , 0);
            hmap.put(temp , hmap.getOrDefault(temp,0)+1);
        }
        return ans;
    }
}