class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int cn1=0,cn2=0;
        int el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
        for(int i=0 ; i<nums.length ; i++){
            if(cn1==0 && el2!=nums[i]){
                cn1=1;
                el1=nums[i];
            }
            else if(cn2==0 && el1!=nums[i]){
                cn2=1;
                el2=nums[i];
            }
            else if (nums[i]==el1)
                cn1++;
            else if (nums[i] == el2)
                cn2++;
            else{
                cn1--;
                cn2--;
            }
        }
        cn1=0;
        cn2=0;
        for(int i=0 ; i<n ; i++){
            if(nums[i]==el1)
                cn1++;
            if (nums[i]==el2)
                cn2++;
        }
        if(cn1>=(n/3)+1)
            ans.add(el1);
        if(cn2>=(n/3)+1)
            ans.add(el2);
        return ans;
    }
}