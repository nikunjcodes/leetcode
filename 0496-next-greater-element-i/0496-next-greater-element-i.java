class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0 ; i<nums1.length ; i++){
            int el = nums1[i];
            int idx=0;
            for(int j=0 ; j<nums2.length ; j++){
                if(nums2[j]==el){
                    idx=j;
                    break;
                }
            }
            for(int j=idx ; j<nums2.length ; j++){
                if(nums2[j]>nums2[idx]){
                    ans[i] = nums2[j];
                    break;
                }
                ans[i] = -1;
            }
        }
            return ans;

    }
}