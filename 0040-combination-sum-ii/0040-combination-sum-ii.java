
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates); 
        helper(0, candidates, target, ans, temp);
        return ans;
    }
    
    public static void helper(int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > target)
                break; 
            temp.add(nums[i]);
            helper(i + 1, nums, target - nums[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
