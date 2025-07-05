class Solution {
    public int findLucky(int[] arr) {
        int[] hash = new int[501];
        for(int i=0 ; i<arr.length ; i++)
            hash[arr[i]]++;
        int ans=-1;
        for(int i=1 ; i<hash.length ; i++){
            if(hash[i]==i)
                ans = i;
        }
        return ans;
    }
}