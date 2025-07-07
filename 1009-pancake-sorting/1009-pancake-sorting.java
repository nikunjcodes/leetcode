class Solution {
        List<Integer> ans = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {
            helper(arr , arr.length);
            return ans;
        
    }
    void helper(int[] arr , int n ){
        if(n==1)
            return;
        int maxI =0;
        for(int i=0  ; i<n ; i++){
            if(arr[i] > arr[maxI])
                maxI = i;
        }
        if(maxI!=0){
            ans.add(maxI+1);
            reverse(arr ,0, maxI);
        }
        ans.add(n);
        reverse(arr ,0, n-1);
        helper(arr,  n-1);
    }
    
    void reverse(int[] arr , int start , int end){
        while(start < end){
            int temp =arr[start];
            arr[start]  =arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}