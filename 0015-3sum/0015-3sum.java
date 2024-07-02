class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0 ; i<nums.length ; i++){
            Set<Integer> st =  new HashSet<>();
            for(int j=i+1 ; j<nums.length ; j++){
                int tar = -(nums[i]+nums[j]);
                if(st.contains(tar)){
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],tar);
                    temp.sort(null);
                    ans.add(temp);
                }
                st.add(nums[j]);
            }
        }
        List<List<Integer>> num =   new ArrayList<>(ans);
        return num;
    }
}