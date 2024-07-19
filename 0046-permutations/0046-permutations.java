class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li  = new ArrayList<>();
        int flag[] = new int[nums.length];
        helper(nums,ans,li,flag);
        return ans;
        
    }
    public static void helper(int[] nums , List<List<Integer>> ans , List<Integer> li , int[] flag){
        if(li.size() == nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=0 ; i<flag.length ; i++){
            if(flag[i]!=1){
                flag[i] = 1;
                li.add(nums[i]);
                helper(nums, ans , li , flag);
                li.remove(li.size()-1);
                flag[i] = 0;
            }
        }
        
    }
}