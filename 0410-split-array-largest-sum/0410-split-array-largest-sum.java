class Solution {
    int helper(int[] arr , int max){
        int k=1;
        int temp=0;
        for(int i=0 ; i<arr.length;  i++){
            if(temp+arr[i]<=max)
                temp+=arr[i];
            else{
                k++;
                temp=arr[i];
            }
        }
        return k;
    }
    public int splitArray(int[] nums, int k) {

        int left=0,right=0;
        for(int num : nums){
            left=Math.max(left,  num);
            right+=num;
        }
        while(left < right){
            int mid = (left+right)/2;
            int temp = helper(nums , mid);
            if(temp>k)
                left= mid+1;
            else
                right = mid;
            
        }
        return left;
        
    }
}