class Solution {
    public void rotate(int[] nums, int k) {
         k = k%nums.length;
        int l =nums.length;
        reverse(nums , 0 , l-1);
        reverse(nums , 0, k-1);
        reverse(nums , k , l-1);
    }
    void reverse(int[] arr , int start , int end){
         while(start<end){
            int temp = arr[start];
            arr[start] =arr[end];
            arr[end] = temp;
            start++;
            end--;
         }
    }
}