class Solution {
    public int hIndex(int[] citations) {
        int left=0;
        int right = citations.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(helper(mid , citations))
                left =  mid+1;
            else
                right = mid-1;
        }
        return citations.length - left;
    }
    boolean helper(int mid, int[] arr){
        if(arr.length - mid > arr[mid])
            return true;
        return false;
    }
}