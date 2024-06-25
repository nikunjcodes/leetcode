class Solution {
    public void sortColors(int[] arr) {
            int low=0,mid=0,high=arr.length-1;
            while(mid<=high){
                if(arr[mid]==1)
                        mid++;
                else if (arr[mid]==0){
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    mid ++;
                    low++;
                    
                }
                else{
                    int temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                }
            }
    }
}