class Solution {
    public long countGood(int[] nums, int k) {
        long ans =0l;
        long count = 0l;
        int i=0;
        int j=0;
        HashMap<Integer , Integer> hmap = new HashMap<>();
        while(j < nums.length){
            hmap.put(nums[j] , hmap.getOrDefault(nums[j],0)+1);
            count += hmap.get(nums[j]) -1;
            while(count >=k){
                ans+=(nums.length -j);
                int left = hmap.get(nums[i]);
                count-=left-1;
                hmap.put(nums[i] , hmap.get(nums[i])-1);
                if(hmap.get(nums[i])==0)
                    hmap.remove(nums[i]);
                i++;
            }
            j++;
        }
        return ans;
    }
}