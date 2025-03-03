class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int i=0;
        int pf=0;
        int[] ans = new int[nums.length];
        for(int num : nums){
            if(num < pivot)
                ans[i++] = num;
            else if (num==pivot)
                pf++;
        }
        while(pf-- > 0)
            ans[i++] = pivot;
        for(int num : nums){
            if(num > pivot)
                ans[i++] = num;
        }
        return ans;
    }

}