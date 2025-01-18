class Solution {
    public int removeDuplicates(int[] nums) {
          int ptr =0;
          for(int n : nums){
            if(ptr<2 || n>nums[ptr-2])
                nums[ptr++] =n;
          }  
          return ptr;
    }
}