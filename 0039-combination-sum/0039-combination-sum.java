class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void helper(int idx, int[] candidates, int target, List<List<Integer>> ans, List<Integer> li) {
        if (target == 0) {
            ans.add(new ArrayList<>(li));
            return;
        }
        if (idx == candidates.length) {
            return;
        }
        if (candidates[idx] <= target) {
            li.add(candidates[idx]);
            helper(idx, candidates, target - candidates[idx], ans, li);
            li.remove(li.size() - 1);
        }
        helper(idx + 1, candidates, target, ans, li);
    }
}
