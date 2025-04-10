class Solution {
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int[] reset() {
            return nums;
    }
    
    public int[] shuffle() {
        if(nums==null)
            return null;
        int[] temp  = nums.clone();
        for(int j=1 ; j<nums.length ; j++){
            int rand = random.nextInt(j+1);
            int t = temp[rand];
            temp[rand] = temp[j];
            temp[j] = t;
        }
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */