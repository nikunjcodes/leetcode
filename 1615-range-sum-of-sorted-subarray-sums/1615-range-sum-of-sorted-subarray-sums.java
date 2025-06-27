class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> num = new ArrayList<>();
        int mod = 1000000007;
        for(int i=0 ; i<nums.length ; i++){
            int sum=nums[i];
            num.add(sum);
            for(int j=i+1 ; j<nums.length ; j++){
               sum+=nums[j];
               num.add(sum);
            }
        }
        long ans=0;
        Collections.sort(num);
        for(int i=left-1 ;i<right ; i++){
                ans+=num.get(i);
        }
        return (int)(ans % mod);
    }
}