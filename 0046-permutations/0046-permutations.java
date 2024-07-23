class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li  = new ArrayList<>();
        int visited[] = new int[nums.length];
        helper(nums,ans,li,visited);
        return ans;
        
    }
    public static void helper(int[] nums , List<List<Integer>> ans , List<Integer> li , int[] visited){
        if(li.size() == nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=0 ; i<visited.length ; i++){
            if(visited[i]!=1){
                visited[i] = 1;
                li.add(nums[i]);
                helper(nums, ans , li , visited);
                li.remove(li.size()-1);
                visited[i] = 0;
            }
        }
        
    }
}