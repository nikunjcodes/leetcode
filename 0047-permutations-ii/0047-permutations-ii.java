class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
                List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li  = new ArrayList<>();
        int visited[] = new int[nums.length];
        Arrays.sort(nums);
        helper(nums,ans,li,visited);
        return ans;
        
    }
    public static void helper(int[] nums , List<List<Integer>> ans , List<Integer> li , int[] visited){
        if(li.size() == nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=0 ; i<visited.length ; i++){
            if(i>0 && nums[i]==nums[i-1] && visited[i-1]!=1)
                continue;
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
